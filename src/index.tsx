import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-geocoding-reversegrocoding' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const GeocodingReversegrocoding = NativeModules.GeocodingReversegrocoding
  ? NativeModules.GeocodingReversegrocoding
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function getLocationFromAddress(address: string): Promise<number> {
  return GeocodingReversegrocoding.getLocationFromAddress(address);
}

export function getAddressFromLocation(a: any, b: any): Promise<number> {
  return GeocodingReversegrocoding.getAddressFromLocation(a, b);
}
