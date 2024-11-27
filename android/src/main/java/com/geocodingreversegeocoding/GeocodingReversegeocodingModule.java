package com.geocodingreversegeocoding;

import android.location.Address;
import android.location.Geocoder;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@ReactModule(name = GeocodingReversegeocodingModule.NAME)
public class GeocodingReversegeocodingModule extends ReactContextBaseJavaModule {
  public static final String NAME = "GeocodingReversegeocoding";
  ReactApplicationContext reactContext;

  public GeocodingReversegeocodingModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void getLocationFromAddress(String strAddress, Promise promise) {
    Geocoder coder = new Geocoder(reactContext);
    List<Address> address;
    try {
      address = coder.getFromLocationName(strAddress, 5);
      if (address != null && address.size() > 0) {
        Address location = address.get(0);
        location.getLatitude();
        location.getLongitude();
        //
        WritableMap result = new WritableNativeMap();
        WritableMap jsonObject = new WritableNativeMap();
        //
        jsonObject.putDouble("lattitude", location.getLatitude());
        jsonObject.putDouble("longitude", location.getLongitude());
        result.putMap("result", jsonObject);

        promise.resolve(result);
      } else {
        // Pass empty JSON Map
        WritableMap result = new WritableNativeMap();
        WritableMap jsonObject = new WritableNativeMap();
        result.putMap("result", jsonObject);
        promise.resolve(result);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

 @ReactMethod
  public void getAddressFromLocation(double lat, double lang, Promise promise) {
    Geocoder geocoder = new Geocoder(reactContext, Locale.ENGLISH);
    try {
      List<Address> addresses = geocoder.getFromLocation(lat, lang, 1);
      WritableMap result = new WritableNativeMap();

      if (addresses != null && !addresses.isEmpty()) {
        Address returnedAddress = addresses.get(0);

        WritableMap jsonObject = new WritableNativeMap();
        WritableMap jsonObjectPosition = new WritableNativeMap();

        jsonObject.putString("adminArea", returnedAddress.getAdminArea());
        jsonObject.putString("city", returnedAddress.getLocality());
        jsonObject.putString("state", returnedAddress.getAdminArea());
        jsonObject.putString("country", returnedAddress.getCountryName());
        jsonObject.putString("countryCode", returnedAddress.getCountryCode());
        jsonObject.putString("feature", returnedAddress.getFeatureName());
        jsonObject.putString("formattedAddress", returnedAddress.getAddressLine(0));
        jsonObject.putString("locality", returnedAddress.getLocality());
        jsonObject.putString("postalCode", returnedAddress.getPostalCode());
        jsonObject.putString("streetName", returnedAddress.getThoroughfare());
        jsonObject.putString("streetNumber", returnedAddress.getSubThoroughfare());
        jsonObject.putString("subAdminArea", returnedAddress.getSubAdminArea());
        jsonObject.putString("subLocality", returnedAddress.getSubLocality());

        jsonObjectPosition.putString("lat", String.valueOf(returnedAddress.getLatitude()));
        jsonObjectPosition.putString("lng", String.valueOf(returnedAddress.getLongitude()));
        jsonObject.putMap("position", jsonObjectPosition);

        result.putMap("result", jsonObject);
      } else {
        // Pass empty JSON Map if no address is found
        result.putMap("result", new WritableNativeMap());
      }

      // Resolve the promise with the result
      promise.resolve(result);

    } catch (Exception e) {
      e.printStackTrace();
      // Handle error by resolving with an empty JSON Map
      WritableMap result = new WritableNativeMap();
      result.putMap("result", new WritableNativeMap());
      promise.resolve(result);
    }
  }
}
