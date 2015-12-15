app.factory('ToDoService', ['$http', '$q', function($http, $q) {
	return {
		getAllTasks: function() {			
			return $http.get('http://localhost:8080/todo/list')
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
            );			
		},
		
		addTask: function(task) {
			console.log(task);
			
			return $http.post('http://localhost:8080/todo/create', task)
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
            );
		},
		
		changeTask: function(id, task) {
			return $http.post('http://localhost:8080/todo/update?id='+id, task)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while updating user');
						return $q.reject(errResponse);
					}
			);
		},
		
		removeTask: function(id) {
			return $http.get('http://localhost:8080/todo/delete?id='+id)
				.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while deleting user');
						return $q.reject(errResponse);
					}
			);
		}
	};
}]);