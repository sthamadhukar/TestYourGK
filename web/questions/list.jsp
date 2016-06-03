<%@ page import="com.testyourgk.model.questions.Questions" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Madhukar
  Date: 5/22/2016
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Questions> questions = (List<Questions>) request.getAttribute("questions");
%>
<jsp:include page="/header.jsp"/>
<div class="container">
  <div class="col-lg-12">
    <div class="col-lg-8">
      <h2>Questions</h2>
    </div>
    <div class="col-lg-4">
      <!-- Button trigger modal -->
      <%--<button class = "btn btn-primary pull-right" id="addNew" data-toggle = "modal" data-target = "#new">--%>
      <button class = "btn btn-primary pull-right" id="addNew">
        Add New Question
      </button>
    </div>

  </div><!--New ticket button div end-->
  <hr/>
  <!-- List of tickets of the member who is logged in-->
  <div class="col-lg-12">
    <div class="table-responsive">
      <table class="table table-responsive table-bordered table-striped tab1 ">
        <thead>
        <tr>
          <th>SN</th>
          <th>Questions</th>
          <th>Options</th>
          <th>Correct Answer</th>
          <th>Related Info</th>
          <th width="10%">Action</th>
        </tr>
        </thead>

        <tbody>
        <%
          int i=1;
          for(Questions question: questions){
        %>
        <tr>
          <td><%=i%><input type="hidden" value="<%=question.getId()%>" /></td>
          <td><%=question.getQuestion()%></td>
          <td><%=question.getOption1()+"&nbsp;||&nbsp;"+question.getOption2()+"&nbsp;||&nbsp;"+question.getOption3()%></td>
          <td><%=question.getCorrectAnswer()%></td>
          <td><%=question.getRelatedInfo()!=null?question.getRelatedInfo():""%></td>
          <td><a href="javascript:void(0)" class="btn btn-primary editQuestion"><span class="glyphicon glyphicon-edit" title="Edit"></span> </a>&nbsp;&nbsp;
            <a href="javascript:void(0)" class="btn btn-danger delete"><span class="glyphicon glyphicon-remove" title="Delete"></span> </a></td>
        </tr>
        <%
            i++;
          }
        %>
        </tbody>
      </table>
    </div>

  </div>

  <div class="col-lg-12" id="modal">
    <!--New ticket form start-->
    <%--<jsp:include page="_addEdit.jsp"/>--%>
  </div>
  <jsp:include page="/footer.jsp"/>
  <script type="text/javascript">
    $(".editQuestion").click(function(e){
      e.preventDefault();
      var id = $(this).parents('tr').find('input[type="hidden"]').val();
      console.log(id)
      var url ="/questions?action=update&questionId="+id;
      $.ajax({
        url: url,
        type: 'POST',

        success: function(response){
          console.log("reached ajax call with url: " + url);
          // set value in input text of modal form
          $('#modal').html(response);
          // open modal
          $('#new').modal('show');
        },
        error: function(err) {
          alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
        }
      });

// on hidden reset bootstrap modal

// on close or hidden modal value will be reset
      $('#new').on('hide.bs.modal', function () {

        $(this).find('form').reset();
      })

    });
    // add New question function
    $("#addNew").click(function(e){
      e.preventDefault();
      var url ="/questions/_addEdit.jsp";
      console.log(url +"clicked");
      $.ajax({
        url: url,
        type: 'POST',

        success: function(response){
          console.log("reached ajax call with url: " + url);
          // set value in input text of modal form
          $('#modal').html(response);
          // open modal
          $('#new').modal('show');
        },
        error: function() {
          alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
        }
      });

// on hidden reset bootstrap modal

// on close or hidden modal value will be reset
      $('#new').on('hide.bs.modal', function () {

        $(this).find('form').reset();
      })

    });
    // delete bootbox script

    $(document).on("click", ".delete", function(e) {
      e.preventDefault();
      var id = $(this).parents('tr').find('input[type="hidden"]').val();
      console.log(id)
      var url ="/questions?action=delete&questionId="+id;  // "make" the intended link in a var
      bootbox.confirm("Are you sure?", function(result) {
        if (result) {

          document.location.href = url;  // if result, "set" the document location
          console.log("deleted"+ id);
        }
        else console.log("donot delete");
      });
    });

  </script>