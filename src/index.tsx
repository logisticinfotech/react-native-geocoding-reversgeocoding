import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-geocoding-reversegeocoding' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const GeocodingReversegeocoding = NativeModules.GeocodingReversegeocoding
  ? NativeModules.GeocodingReversegeocoding
  : new Proxy(
    {},
    {
      get() {
        throw new Error(LINKING_ERROR);
      },
    }
  );

export function getLocationFromAddress(address: string): Promise<number> {
  return GeocodingReversegeocoding.getLocationFromAddress(address);
}

export function getAddressFromLocation(a: any, b: any): Promise<number> {
  return GeocodingReversegeocoding.getAddressFromLocation(a, b);
}
