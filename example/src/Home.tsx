import React, { useEffect, useState } from 'react';
import {
    Text,
    TouchableOpacity,
    View,
    NativeModules,
    TextInput,
} from 'react-native';

export const { DemoAppManager, LocationAppModule } = NativeModules;
import {
    getLocationFromAddress,
    getAddressFromLocation,
} from 'react-native-geocoding-reversegeocoding';

const Home = () => {
    const [convertedDate, setConvertedDate] = useState();
    const [formateDate, setFormateDate] = useState();
    const [hardwareId, setHardwareId] = useState();
    const [latLang, setLatLang] = useState();
    const [address, setAddress] = useState();
    let staticAddress = 'Madhapar chowk, Rajkot';
    let staticLat = 22.3314972;
    let staticLng = 70.7689625;

    const onPressGetLatLangFromAddress = async () => {
        await getLocationFromAddress(staticAddress).then((response) => {
            console.log('getLocationFromAddress :', response);
            if (response?.result) {
                setLatLang(JSON.stringify(response?.result));
            }
        });
    };

    const onPressGetAddressFromLatLang = async () => {
        await getAddressFromLocation(staticLat, staticLng).then((response) => {
            console.log('getAddressFromLocation :', response);
            if (response) {
                setAddress(JSON.stringify(response?.result));
            }
        });
    };

    return (
        <>
            <View
                style={{
                    height: '100%',
                    backgroundColor: '#eeeeee',
                    justifyContent: 'center',
                    alignContent: 'center',
                }}
            >
                <View>
                    <Text
                        style={{
                            color: 'black',
                            fontSize: 18,
                            textAlign: 'center',
                            marginHorizontal: 15,
                        }}
                    >
                        An example of Geocoding-Reverse geocoding
                    </Text>

                    {/* Lat/Lang from Address */}
                    <View
                        style={{
                            marginTop: 20,
                            paddingVertical: 20,
                            borderColor: 'black',
                            borderWidth: 1,
                            marginHorizontal: 15,
                            borderRadius: 10,
                        }}
                    >
                        <TouchableOpacity
                            onPress={onPressGetLatLangFromAddress}
                            style={{
                                alignSelf: 'center',
                                backgroundColor: 'black',
                                paddingHorizontal: 15,
                                paddingVertical: 10,
                            }}
                        >
                            <Text
                                style={{
                                    color: 'white',
                                }}
                            >
                                Get Lat/Lang from Address
                            </Text>
                        </TouchableOpacity>
                        <Text
                            style={{
                                alignSelf: 'center',
                                color: 'black',
                                marginTop: 10,
                            }}
                        >
                            Static address is : {staticAddress}
                        </Text>
                        {latLang ? (
                            <Text
                                style={{
                                    alignSelf: 'center',
                                    color: 'black',
                                    marginTop: 10,
                                    marginHorizontal: 15,
                                }}
                            >
                                Lat/Lang from Address is : {latLang}
                            </Text>
                        ) : null}
                    </View>
                    {/* Lat/Lang from Address - Over */}

                    {/* Address from Lat/Lang */}
                    <View
                        style={{
                            marginTop: 20,
                            paddingVertical: 20,
                            borderColor: 'black',
                            borderWidth: 1,
                            marginHorizontal: 15,
                            borderRadius: 10,
                        }}
                    >
                        <TouchableOpacity
                            onPress={onPressGetAddressFromLatLang}
                            style={{
                                alignSelf: 'center',
                                backgroundColor: 'black',
                                paddingHorizontal: 15,
                                paddingVertical: 10,
                            }}
                        >
                            <Text
                                style={{
                                    color: 'white',
                                }}
                            >
                                Get Address from Lat/Lang
                            </Text>
                        </TouchableOpacity>
                        <Text
                            style={{
                                alignSelf: 'center',
                                color: 'black',
                                marginTop: 10,
                            }}
                        >
                            Static Lat/Lang is : {staticLat} &amp; {staticLng}
                        </Text>
                        {address ? (
                            <Text
                                style={{
                                    alignSelf: 'center',
                                    color: 'black',
                                    marginTop: 10,
                                    marginHorizontal: 15,
                                }}
                            >
                                Address from Lat/Lang is : {address}
                            </Text>
                        ) : null}
                    </View>
                    {/* Address from Lat/Lang - Over */}
                </View>
            </View>
        </>
    );
};

export default Home;
