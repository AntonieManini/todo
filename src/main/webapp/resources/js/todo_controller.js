app.controller('ToDoController', ['$scope', 'ToDoService', function($scope, ToDoService) {
	var self = this;
	var emptyTask = {id:null, text:'', done:false, date:''};
	
	self.task = emptyTask;
	self.tasks = null;
	
	self.getAllTasks = function() {
		ToDoService.getAllTasks()
        .then(
                     function(d) {
                          self.tasks = d;
                     },
                      function(errResponse){
                          console.error('Error while fetching Currencies');
                      }
             );
	};
	
	self.addTask = function(task) {
		ToDoService.addTask(task)
        .then(
        		self.getAllTasks, 
                function(errResponse){
                     console.error('Error while creating User.');
                } 
        );		
	};
	
	self.changeTask = function(id, task) {
		ToDoService.changeTask(id, task)                      
			.then(
                self.getAllTasks, 
                function(errResponse){
                     console.error('Error while updating User.');
                } 
			);
	};
	
	self.removeTask = function(id) {
		ToDoService.removeTask(id)
			.then(
                self.getAllTasks, 
                function(errResponse){
                     console.error('Error while deleting User.');
                } 
			);
	};
	
	
	
	self.getAllTasks();	
	
	self.submit = function() {
		if (self.task.id == null) {
			self.addTask(self.task);			
		}
		else {			
			self.changeTask(self.task.id, self.task);
		}
		
		self.reset();
	};
	
	
	self.change = function(id) {
		for(var i=0; i < self.tasks.length; i++) {
			if (self.tasks[i].id == id) {
				self.task = angular.copy(self.tasks[i]);
				
				break;
			}
		}
	};
	
	self.remove = function(id) {
		self.removeTask(id);
		
		self.reset();
	};
	
	
	self.reset = function() {
		self.task = {id:null, text:'', done:false, date:''};
		//$scope.submitForm.$setPristine();
	};
}]);