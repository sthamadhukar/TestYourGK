package com.testyourgk.controller.questions;

import com.testyourgk.model.questions.Questions;
import com.testyourgk.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Madhukar on 5/22/2016.
 */
@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
       // response.setContentType("text/html");
        String action = request.getParameter("action")!=null? request.getParameter("action") :"list";
        Questions question = new Questions();
        QuestionService questionService = new QuestionService();
        // Users sessionUser = (Users)request.getSession().getAttribute("isVerifiedMember");
        //int userId = sessionUser.getId();
        int userid = 1;
        //System.out.println(sessionUser);
        if(action.equals("list")){
            request.setAttribute("questions",questionService.listQuestions());
            request.getRequestDispatcher("/questions/list.jsp").forward(request,response);
        }
        if(action.equals("addNew")){
            String addedquestion = request.getParameter("question");
            String correctAnswer = request.getParameter("correctAnswer");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String relatedInfo = request.getParameter("relatedInfo");
            questionService.save(new Questions(addedquestion, relatedInfo, option1, option2, option3, correctAnswer));

            response.sendRedirect("/questions");
            //  set values to questions fields added by user
            Enumeration paramNames = request.getParameterNames();
            while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();
                System.out.print("<tr><td>" + paramName + "</td>\n");
                String paramValue = request.getParameter(paramName);
                System.out.println("<td> " + paramValue + "</td></tr>\n");


            }
        }


        if(action.equals("update")){
            int questionId =Integer.parseInt(request.getParameter("questionId"));
            Questions questionToUpdate = questionService.listQuestions(questionId);
            request.setAttribute("question", questionToUpdate);
            request.getRequestDispatcher("/questions/_addEdit.jsp").forward(request,response);
        }

        if(action.equals("processUpdate")){
            int questionId = Integer.parseInt(request.getParameter("id"));
            String addedquestion = request.getParameter("question");
            String correctAnswer = request.getParameter("correctAnswer");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String relatedInfo = request.getParameter("relatedInfo");
            Questions updatedQuestion = new Questions(addedquestion, relatedInfo, option1, option2, option3, correctAnswer);
            updatedQuestion.setId(questionId);
            questionService.updateQuestion(updatedQuestion);

            response.sendRedirect("/questions");
        }
        if(action.equals("delete")){
            int questionId =Integer.parseInt(request.getParameter("questionId"));
            questionService.deleteQuestion(questionId);
            response.sendRedirect("/questions");
            //request.getRequestDispatcher("/questions/_addEdit.jsp").forward(request,response);
        }
    }
}
