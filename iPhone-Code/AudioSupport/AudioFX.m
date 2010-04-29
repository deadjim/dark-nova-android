//
//  AudioFX.m
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

#import <AudioToolbox/AudioServices.h>
#import "AudioFX.h"
#import "Audio_Internal.h"


//CLASS IMPLEMENTATIONS:

@implementation AudioFX

static void _AudioServicesSystemSoundCompletionProc(SystemSoundID  ssID, void* clientData)
{
	NSAutoreleasePool*			pool = [NSAutoreleasePool new];
	AudioFX*					self = (AudioFX*)clientData;
	
	[self->_delegate audioFXDidComplete:self];
	
	[pool release];
}
											
@synthesize tag=_tag, delegate=_delegate;

#if TARGET_OS_IPHONE

+ (void) vibrate
{
	AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
}

#endif

+ (BOOL) playAtPath:(NSString*)path
{
	AudioFX*					audioFX;
	
	audioFX = [[AudioFX alloc] initWithPath:path];
	if(audioFX == nil)
	return NO;
	
	[audioFX setDelegate:self];
	[audioFX play];
	
	return YES;
}

+ (void) audioFXDidComplete:(AudioFX*)audioFX
{
	[audioFX release];
}

- (id) initWithPath:(NSString*)path
{
	if((self = [super init])) {
		if(![path isAbsolutePath])
		path = [[NSBundle mainBundle] pathForResource:path ofType:nil];
		
		if(!CALL_OSSTATUS_FUNCTION(AudioServicesCreateSystemSoundID, (CFURLRef)[NSURL fileURLWithPath:path], &_soundID)) {
			REPORT_ERROR(@"Failed opening sound file at path \"%@\"", path);
			[self release];
			return nil;
		}
	}
	
	return self;
}

- (void) dealloc
{
	if(_soundID) {
		if(_hasCallback)
		AudioServicesRemoveSystemSoundCompletion(_soundID);
		AudioServicesDisposeSystemSoundID(_soundID);
	}
	
	[super dealloc];
}

- (void) play
{
	AudioServicesPlaySystemSound(_soundID);
}

- (void) setDelegate:(id<AudioFXDelegate>)delegate
{
	_delegate = delegate;
	
	if(_delegate) {
		if(!_hasCallback && CALL_OSSTATUS_FUNCTION(AudioServicesAddSystemSoundCompletion, _soundID, NULL, NULL, _AudioServicesSystemSoundCompletionProc, self))
		_hasCallback = YES;
	}
	else {
		if(_hasCallback) {
			AudioServicesRemoveSystemSoundCompletion(_soundID);
			_hasCallback = NO;
		}
	}
}

@end
