<%@ page import="com.testyourgk.model.questions.Questions" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%--
  Created by IntelliJ IDEA.
  User: Madhukar
  Date: 5/26/2016
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Questions nextQuestion = null;
  String question = null;
  List<String> options = new ArrayList<String>();
  if (request.getAttribute("nextQuestion") != null) {
    nextQuestion = (Questions) request.getAttribute("nextQuestion");
    //shuffle through the option with new list
    question = nextQuestion.getQuestion();
    options.add(nextQuestion.getCorrectAnswer());
    options.add(nextQuestion.getOption1());
    options.add(nextQuestion.getOption2());
    options.add(nextQuestion.getOption3());
    Collections.shuffle(options);
    for(String option:options){
      System.out.println(option);
    }
  }
%>
<form name="playQuiz">
<div class="col-lg-12">
  <h3><%=question%></h3>
</div>

<div class="col-lg-12 row">
  <%  for(String option: options){
  %>
    <label class="radio-inline"> <input type="radio" name="option" value="<%=option%>"/><%=option%></label>
  <% }%>
</div>
  <div class="row col-lg-4"><button type="submit" class="btn btn-primary  pull-right" id="next">Next</button> </div>
</form>
<script type="text/javascript">
  //next
  $("#next").click(function(e){
    e.preventDefault();
    var selected = $("input[type='radio'][name='option']:checked");
    if (selected.length > 0) {
      selectedVal = selected.val();
      console.log(selectedVal);
      $.ajax({
        url:"/play?action=getNext",
        type: 'POST',

        success: function(response){
          console.log("reached ajax call with url: ");
          $("#displayQuestion").empty();
          // set value in input text of modal form
          $('#displayQuestion').html(response);
          // show question
          $("#displayQuestion").css("display","block;");
        },
        error: function(err) {
          alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
        }
      });
    }
    else{
      bootbox.alert("Please choose answer to proceed!!")

    }

  })
</script>