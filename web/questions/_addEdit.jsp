<%@ page import="com.testyourgk.model.questions.Questions" %>
<%--
  Created by IntelliJ IDEA.
  User: Madhukar
  Date: 5/22/2016
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Questions question = null;
  if(request.getAttribute("question")!=null){
    question = (Questions)request.getAttribute("question");
  }
%>
<!-- Modal for add new ticket -->
<div class = "modal fade" id = "new" tabindex = "-1" role = "dialog" aria-labelledby = "newQuestionLabel" aria-hidden = "true">

  <div class = "modal-dialog" role="document">
    <div class = "modal-content">

      <div class = "modal-header">
        <button type = "button" class = "close" data-dismiss = "modal" aria-hidden = "true">
          &times;
        </button>

        <h4 class = "modal-title" id = "addEditQuestion">
          Add/Edit Question
        </h4>
      </div>
      <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/questions?action=<%=question!=null?"processUpdate":"addNew"%>" method="post">
        <%=question!=null?"<input type=\"hidden\" name=\"id\" value=\""+question.getId()+"\"/>":""%>
        <div class = "modal-body">

          <div class="form-group">
            <label>Question</label><span style="color: red;">*</span>
            <div class="input-group col-lg-12">
              <input type="text" name="question" class="form-control" placeholder="Write Question" value="<%=question!=null?question.getQuestion():""%>" required autofocus />
            </div>
          </div>
          <div class="form-group">
            <label>Correct Answer</label><span style="color: red;">*</span>
            <div class="input-group col-lg-12">
              <input type="text" name="correctAnswer" class="form-control" placeholder="Correct Answer" value="<%=question!=null?question.getCorrectAnswer():""%>" required />
            </div>
          </div>

          <div class="row">
            <label class="input-group">Other options<span style="color: red;">*</span></label><div class="clearfix"></div>

            <div class="col-md-4 pull-left">
              <input type="text" name="option1" class="form-control" placeholder="First Option" value="<%=question!=null?question.getOption1():""%>" required />
            </div>
            <div class="col-md-4">
              <input type="text" name="option2" class="form-control" placeholder="Second Option" value="<%=question!=null?question.getOption2():""%>" required />
            </div>
            <div class="col-md-4 pull-right">
              <input type="text" name="option3" class="form-control" placeholder="Third Option" value="<%=question!=null?question.getOption3():""%>" required />
            </div>
          </div>
          <div class="clearfix">&nbsp;</div>
          <div class="form-group">
            <div class="input-group col-lg-12">
              <label>Related Information</label>
              <textarea id="info" class="form-control" name="relatedInfo" rows="3" cols="5" placeholder="Some info about question as a hint"><%=question!=null&&question.getRelatedInfo()!=null?question.getRelatedInfo():""%></textarea>
            </div>
          </div>
        </div>

        <div class = "modal-footer ">
          <button class="btn btn-primary" type="submit"><%=question!=null?"Update":"Add"%></button>
          <button type = "button" class = "btn btn-danger" data-dismiss = "modal">Cancel</button>
        </div>

      </form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
