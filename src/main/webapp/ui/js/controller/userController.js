'use strict';
App.controller('userController', [ '$scope', '$rootScope', 'userService',
		'$http', function($scope, $rootScope, userService, $http) {

			$scope.user = {};
			$scope.user.email = "";
			$scope.user.password = "";
			$scope.txn = {};
			$scope.txn.txnDate = "";
			$scope.txn.txnDoneBy="";
			$scope.txn.txnAddedBy="";
			$scope.txn.txnCategory="";
			$scope.txn.txnDetails="";
			$scope.txn.txnAmount="";
			$scope.showUserDetails = false;
			$scope.showLogin = true;
			$scope.createTransaction = true;
			$scope.userDetails = [];
			$scope.userData = {};
			$scope.userData.firstName="";
			$scope.userData.lastName="";
			$scope.userData.password="";
			$scope.userData.email="";
			$scope.userData.phoneNumber="";

			$scope.login1 = function() {
				userService.postUserData($scope.user).then(function(d) {
					$scope.showLogin = false;
					$scope.showUserDetails = true;
					$scope.createTransaction = true;
					$scope.getUserDetails();
				});
			};

			$scope.getUserDetails = function() {
				userService.getUserDetails().then(function(d) {
					$scope.userDetails = d;
				});
			};
			
			$scope.createTransaction = function() {
				userService.createTransaction($scope.txn).then(function(d){
					userService.createTransaction = d;
				});
			};
			
			$scope.createUser = function(){
				userService.createUser($scope.userData).then(function(d){
					userService.createUser = d;
				});
			}
		} ]);