/* global google */

function initialize() {

    var mapOptions, map, marker, searchBox, city,
            infoWindow = '',
            addressEl = document.querySelector('#map-search'),
            latEl = document.querySelector('.latitude'),
            longEl = document.querySelector('.longitude'),
            element = document.getElementById('map-canvas');
    city = document.querySelector('.reg-input-city');

    mapOptions = {

        zoom: 15,
        center: new google.maps.LatLng(21.0277644, 105.8341598),

        disableDefaultUI: false,
        scrollWheel: true,
        draggable: true
    };


    // Create an object map with the constructor function Map()
    map = new google.maps.Map(element, mapOptions);


    // Creates the marker on the map

    marker = new google.maps.Marker({
        position: mapOptions.center,
        map: map,
        draggable: true
    });


    // Creates a search box

    searchBox = new google.maps.places.SearchBox(addressEl);

    google.maps.event.addListener(searchBox, 'places_changed', function () {
        var places = searchBox.getPlaces(),
                bounds = new google.maps.LatLngBounds(),
                i, place, lat, long, resultArray,
                addresss = places[0].formatted_address;

        for (i = 0; place = places[i]; i++) {
            bounds.extend(place.geometry.location);
            marker.setPosition(place.geometry.location);
        }

        map.fitBounds(bounds);
        map.setZoom(15);

        lat = marker.getPosition().lat();
        long = marker.getPosition().lng();

        console.log(lat);
        console.log(long);

        latEl.value = lat;
        longEl.value = long;

        resultArray = places[0].address_components;

        // Closes the previous info window if it already exists
        if (infoWindow) {
            infoWindow.close();
        }

        infoWindow = new google.maps.InfoWindow({
            content: addresss
        });

        infoWindow.open(map, marker);
    });

    google.maps.event.addListener(marker, "dragend", function (event) {
        var lat, long, address, resultArray, citi;

        lat = marker.getPosition().lat();
        long = marker.getPosition().lng();

        console.log(lat);
        console.log(long);

        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({latLng: marker.getPosition()}, function (result, status) {
            if ('OK' === status) {  // == if ( status == google.maps.GeocoderStatus.OK ) {
                address = result[0].formatted_address;
                resultArray = result[0].address_components;

                addressEl.value = address;
                latEl.value = lat;
                longEl.value = long;

            } else {
                console.log('Geocode was not successful for the following reason: ' + status);
            }
            
            if (infoWindow) {
                infoWindow.close();
            }

            infoWindow = new google.maps.InfoWindow({
                content: address
            });

            infoWindow.open(map, marker);
        });
    });
}