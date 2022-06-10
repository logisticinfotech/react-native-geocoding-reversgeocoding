#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(GeocodingReversegrocoding, NSObject)

RCT_EXTERN_METHOD(getLocationFromAddress:(NSString *)address
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(getAddressFromLocation:(double)lat withB:(double)lang
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)

@end
