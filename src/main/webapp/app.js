/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module("testApp",[])
        .controller("TareaController",
            ['$scope','$http',function($scope,$http){
                $scope.tarea={};
                $scope.tareas=[];
                $scope.crear = function(){
                   $http.post("api/tarea/",$scope.tarea)
                        .success(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                            $scope.tareas.push(data);
                        })
                        .error(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                        });
                }
                $scope.borrar = function(){
                   $http.delete("api/tarea/"+$scope.tarea.id)
                        .success(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                            // esto está mal pero es mas facil
                            // cargo la lista completa
                            $scope.buscarTodas();
                        })
                        .error(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                        });
                }
                 $scope.actualizar = function(){
                   $http.put("api/tarea/"+$scope.tarea.id,$scope.tarea)
                        .success(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                            // esto está mal pero es mas facil
                            // cargo la lista completa
                            $scope.buscarTodas();
                        })
                        .error(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                        });
                }
                $scope.buscarPorId = function(){
                   $http.get("api/tarea/"+$scope.tarea.id)
                        .success(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                            $scope.tareas=[];
                            $scope.tareas.push(data);
                        })
                        .error(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                        });
                }
                $scope.buscarTodas = function(){
                   $http.get("api/tarea/")
                        .success(function(data, status, headers, config) {
                            console.log(data);
                            $scope.tareas=data;
                            console.log(status);
                        })
                        .error(function(data, status, headers, config) {
                            console.log(data);
                            console.log(status);
                        });
                }
            }]
);