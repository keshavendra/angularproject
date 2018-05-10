'use strict';

App.factory('userService', function($http, $q) {
	return {

		postUserData : function(user) {
			var config = {
				headers : {
					'Content-Type' : 'application/json'
				}
			}
			return $http.post('validate', user, config)
					.then(
							function(response) {
								return response.data;
							},
							function(errResponse) {
								alert(errResponse.status + ':'
										+ errResponse.statusText);
								return $q.reject(errResponse);
							});
		},

		getUserDetails : function() {
			return $http.get('details').then(function(response) {
				return response.data;
			}, function(errResponse) {
				alert(errResponse.status + ':' + errResponse.statusText);
				return $q.reject(errResponse);
			});
		},
		createTransaction : function(txn){
			var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
				}
				return $http.post('createTransaction', txn, config)
						.then(
								function(response) {
									return response.data;
								},
								function(errResponse) {
									alert(errResponse.status + ':'
											+ errResponse.statusText);
									return $q.reject(errResponse);
								});
			},
			createUser : function(userData){
				var config = {
						headers : {
							'Content-Type' : 'application/json'
						}
					}
					return $http.post('createUser', userData, config)
							.then(
									function(response) {
										return response.data;
									},
									function(errResponse) {
										alert(errResponse.status + ':'
												+ errResponse.statusText);
										return $q.reject(errResponse);
									});
				}
	};
});