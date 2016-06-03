package com.testyourgk.controller.questions;

import com.sun.deploy.net.HttpResponse;
import com.testyourgk.model.play.PlaySession;
import com.testyourgk.model.questions.Questions;
import com.testyourgk.service.PlayService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Madhukar on 5/26/2016.
 */
@WebServlet(name = "PlayQuiz", urlPatterns = "/play")
public class PlayQuiz extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String action = request.getParameter("action")!=null? request.getParameter("action") :"play";
        if(action.equals("play")){
            session.setAttribute("playSession", new PlaySession());
            request.getRequestDispatcher("/playQuiz/playQuiz.jsp").forward(request,response);

        }
        if(action.equals("getNext")){

            PlaySession playSession = (PlaySession)session.getAttribute("playSession");

            List<Integer> questionPlayed = playSession.getQuestionPlayed();
            Questions nextQuestion = new PlayService().getNext(questionPlayed);
            System.out.println(nextQuestion.getId());
            questionPlayed.add(nextQuestion.getId());
            playSession.setQuestionPlayed(questionPlayed);
            playSession.setNumberOfQuestionPlayed(playSession.getNumberOfQuestionPlayed() + 1);
            session.setAttribute("playSession",playSession);

            request.setAttribute("nextQuestion", nextQuestion);
            request.getRequestDispatcher("/playQuiz/_displayQuestion.jsp").forward(request,response);
        }
        if(action.equals("end")){

        }

    }
}
