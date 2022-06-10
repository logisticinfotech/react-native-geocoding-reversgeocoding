# react-native-geocoding-reversegrocoding

* No need to use Native modules anymore.
* No need to generate Google API key for geocoding functionality in react-native anymore.
* This lib returns the Address/Lat-Lang WITHOUT using GOOGLE API key

## Demo

![This demo.](/react-native-geocoding-reversegeocoding.gif "This is a sample.")

## Installation

```sh
npm install react-native-geocoding-reversegrocoding
```

### Android 
> It'll auto link the library. No need to manually install gradle project.

### iOS
> pod installation

```sh
cd ios
pod install
cd ..
```
> If you're having M1 Chip Mac, please follow below command

```sh
cd ios
arch -x86_64 pod install
cd ..
```

## Response/Output

> : `"getLocationFromAddress"`

```js
{
  "result": {
    "lattitude": *2.3*****,
    "longitude": *0.7*****
  }
}
```
> : `"getAddressFromLocation"`

```js
{
  "result": {
    "adminArea": "**j**at",
    "city": "***ko**",
    "state": "**j**at",
    "country": "India",
    "countryCode": "IN",
    "feature": "8*****9F",
    "formattedAddress": "Ma*****, ****, ****006, India",
    "locality": "***ko**",
    "position": {
      "lat": "2.3*****",
      "lng": "0.7*****"
    },
    "postalCode": "***00**",
    "streetName": "",
    "streetNumber": "",
    "subAdminArea": "***ko**",
    "subLocality": "****ap**"
  }
}
```

## Usage

```js
import { 
    getLocationFromAddress, 
    getAddressFromLocation 
} from "react-native-geocoding-reversegrocoding";

// ...
// ...

const result = await getLocationFromAddress("Ma****ar chowk, Ra****"); // String
or
await getLocationFromAddress("Ma****ar chowk, Ra****")
    .then((response)=> {
        if(response?.result) {
            console.log(response.result)
        }
    }).catch((error)=>{
        console.log(error)
    })

// ...
// ...
const result = await getAddressFromLocation(*2.33*****, *0.76*****); // Double
or
await getAddressFromLocation(*2.33*****, *0.76*****)
    .then((response)=> {
        if(response?.result) {
            console.log(response.result)
        }
    }).catch((error)=>{
        console.log(error)
    })
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
