(function () {
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

        BookingsController.$inject = ['$http'];

    function BookingsController($http) {
        var vm = this;

        vm.bookings = [];
        vm.getAllBookings = getAllBookings;
        vm.getAffordableBookings = getAffordableBookings;
        vm.deleteBooking = deleteBooking;
        
        init();
        
        function init() {

            getAllBookings();
        }

        function getAllBookings() {

            var url = "/bookings/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {

                vm.bookings = response.data;
            });
        }
        
        function getAffordableBookings() {

            var url = "/bookings/affordable/" + 150;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {

                vm.bookings = response.data;
            });
        }
        
        function deleteBooking(id) {

            var url = "/bookings/delete/" + id;
            $http.post(url).then(function (response) {

                vm.bookings = response.data;
            });
        }
    }
})();