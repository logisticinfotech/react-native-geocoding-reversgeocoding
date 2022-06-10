import CoreLocation

@objc(GeocodingReversegrocoding)
class GeocodingReversegrocoding: NSObject {
    
    @objc(getLocationFromAddress:withResolver:withRejecter:)
    func getLocationFromAddress(_ address: String, resolver resolve:@escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock) -> Void {
        
        let geocoder = CLGeocoder()
        geocoder.geocodeAddressString(address) { placemarks, error in
            
            if error != nil {
                // return
                var result: Dictionary<String, String> = [:]
                let results = [
                    "result" : result
                ]as [String : Any]
                resolve(results)
            } else {
                let plMarks = placemarks![0] as? CLPlacemark
                var name = NSNull() as? String
                
                // ar plMarks = placemarks
                let finalLocation = plMarks?.location?.coordinate
                // print("Final Location", (finalLocation!))
                
                let result = [
                    "result" : [
                        "lattitude" : plMarks?.location?.coordinate.latitude,
                        "longitude" : plMarks?.location?.coordinate.longitude,
                    ]
                ] as [String : Any]
                
                resolve(result)
            }
            
        }
    }
    
    @objc(getAddressFromLocation:withB:withResolver:withRejecter:)
    func getAddressFromLocation(_ lat: Double, _ lang: Double, resolver resolve:@escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock) -> Void {
        
        let geoCoder = CLGeocoder()
        let location = CLLocation(latitude: lat , longitude: lang)
        
        geoCoder.reverseGeocodeLocation(location, completionHandler: { (placemarks, error) -> Void in
            
            if let error = error {
                // return
                var result: Dictionary<String, String> = [:]
                let results = [
                    "result" : result
                ]as [String : Any]
                resolve(results)
            } else {
                if placemarks == nil {
                    // print("Response GeoLocation : \(placemarks)")
                    var result: Dictionary<String, String> = [:]
                    let results = [
                        "result" : result
                    ]as [String : Any]
                    resolve(results)
                } else {
                    // print("Response GeoLocation : \(placemarks)")
                    var placeMark: CLPlacemark!
                    placeMark = placemarks?[0]
                    // print("placeMark :- \(placeMark)")
                    
                    let lines = placeMark?.addressDictionary?["FormattedAddressLines"] as? [String]
                    var name = NSNull() as? String
                    if (placeMark?.name != placeMark?.locality) && (placeMark?.name != placeMark?.thoroughfare) && (placeMark?.name != placeMark?.subThoroughfare) {
                        name = placeMark?.name
                    }
                    
                    let results = [
                        "result" : [
                            "adminArea": placeMark?.administrativeArea ?? "",
                            "country": placeMark?.country ?? "",
                            "city": placeMark?.locality ?? "",
                            "state": placeMark?.administrativeArea ?? "",
                            "countryCode": placeMark?.isoCountryCode ?? "",
                            "feature": name,
                            "formattedAddress": lines?.joined(separator: ", ") ?? "",
                            "locality": placeMark?.locality ?? "",
                            "position": [
                                "lat": placeMark?.location?.coordinate.latitude,
                                "lng": placeMark?.location?.coordinate.longitude
                            ],
                            "postalCode": placeMark?.postalCode ?? "",
                            "streetName": placeMark?.thoroughfare ?? "",
                            "streetNumber": placeMark?.subThoroughfare ?? "",
                            "subAdminArea": placeMark?.subAdministrativeArea ?? "",
                            "subLocality": placeMark?.subLocality ?? "",
                            
                        ]  as [String : Any]
                    ]
                    // print("Results :- \(results)")
                    resolve(results)
                }
            }
        }
        )}
}
