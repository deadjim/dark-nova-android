//
//  AudioFX.h
// This file is Part of Dark Nova.
//
// Dark Nova is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Dark Nova is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Dark Nova.  If not, see <http://www.gnu.org/licenses/>.
//
//  Created by Dead Jim Studios on 6/15/09.
//  Copyright Dead Jim Studios 2009. All rights reserved.
//

#import <Foundation/Foundation.h>


//CLASSES:

@class AudioFX;

//PROTOCOLS:

@protocol AudioFXDelegate <NSObject>
- (void) audioFXDidComplete:(AudioFX*)audioFX;
@end

//CLASS INTERFACES:

/*
This class wraps the AudioServices APIs from CoreAudio to allow playback of small sound files with no panning or volume controls.
Use this class to play casual sounds during user interface interaction (keyboard like, lock/unlock...).
Make sure the sound files are small and uncompressed or IMA.
When you have lots of small sounds and don't really care about the latency response when playing them, it's recommended to create and destroy AudioFX instances on demand instead of allocating them all upfront - or use the +playAtPath: method.
*/
@interface AudioFX : NSObject
{
@private
	UInt32					_soundID;
	NSInteger				_tag;
	id<AudioFXDelegate>		_delegate;
	BOOL					_hasCallback;
}
#if TARGET_OS_IPHONE
+ (void) vibrate; //iPhone only
#endif

+ (BOOL) playAtPath:(NSString*)path; //One-shot sound playback

- (id) initWithPath:(NSString*)path; //If the path is not absolute, it is assumed to be relative to the main bundle's resources

@property NSInteger tag;

@property(assign) id<AudioFXDelegate> delegate;

- (void) play;
@end
