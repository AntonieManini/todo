<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ToDo</title>	
</head>
<body ng-app="todo-app">

	 <div class="container" ng-controller="ToDoController as todo">
	
		<div class="left-pane">
			<table>
				<th>Task</th>
				<th>Done</th>
				<th>Creation Date</th>
				<tr ng-repeat="t in todo.tasks">
					<td ng-bind="t.id"></span></td>
					<td ng-bind="t.text"></span></td>
					<td ng-bind="t.done"></span></td>
					<td ng-bind="t.date"></span></td>
					<td>
						<button ng-click="todo.change(t.id)">Edit</button>
						<button ng-click="todo.remove(t.id)">Remove</button>
					</td>
				</tr>
			</table>
		</div>
		
		
		<div class="right-pane">
   		  <form ng-submit="todo.submit()" name="submitForm">		
			<input type="hidden" ng-model="todo.task.id"/>		
			<input type="text" ng-model="todo.task.text"/>
			<input type="{{todo.task.id ? 'checkbox' : 'hidden'}}" ng-model="todo.task.done"/>
			<input type="hidden" ng-model="todo.task.date"/ name="date"/>
			<input type="submit" value="{{todo.task.id ? 'Update' : 'Create'}}"/>
		  </form>
		</div>
			
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/angular.min.js"/>"></script>	
	<script src="<c:url value="/resources/js/main.js"/>"></script>
	<script src="<c:url value="/resources/js/todo_controller.js"/>"></script>
	<script src="<c:url value="/resources/js/todo_service.js"/>"></script>
</body>
</html>