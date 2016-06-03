<%--
  Created by IntelliJ IDEA.
  User: Madhukar
  Date: 5/26/2016
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Play Quiz</title>
  <link href="${pageContext.request.contextPath}/includes/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css" rel="stylesheet">
      .vertical-center-row {
        display: table-cell;
        vertical-align: middle;
      }
    </style>
</head>
<body>

<div class="container-fluid vertical-center">
  <div class="center-block text-center" id="startQuiz" style="padding-top:150px;;">
    <button class="btn btn-primary">Play Quiz</button>
  </div>
  <div id="displayQuestion" class="center-block">

  </div>
</div>

</body>
<jsp:include page="/footer.jsp"/>
<script type="text/javascript">
  $("#startQuiz").click(function(){
    $(this).remove();
    $.ajax({
      url:"/play?action=getNext",
      type: 'POST',

      success: function(response){
        console.log("reached ajax call with url: ");
        // set value in input text of modal form
        $('#displayQuestion').html(response);
        // show question
        $("#displayQuestion").css("display","block;");
      },
      error: function(err) {
        alert(err);
        //alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
      }
    });
  })
</script>

