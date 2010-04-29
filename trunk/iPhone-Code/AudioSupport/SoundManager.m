//
//  SoundManager.m
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

#import "SoundManager.h"
#import "AudioFX.h"

static SoundManager *sharedSound;

@implementation SoundManager	

@synthesize soundArray;

+ (id)sharedSound {
    if (!sharedSound) {
        sharedSound = [[SoundManager alloc] init];
    }
    return sharedSound;
}

- (void)dealloc {
    [soundArray release];
    [super dealloc];
}

- (void)startAudio:(id)sender {
	
	AudioFX *fxAirWrench = [[[AudioFX alloc] initWithPath:@"AirWrench.caf"] autorelease];
	AudioFX *fxCashReg = [[[AudioFX alloc] initWithPath:@"CashReg.caf"] autorelease];
	AudioFX *fxFireLaser = [[[AudioFX alloc] initWithPath:@"FireLaser.caf"] autorelease];
	AudioFX *fxHyperWarp = [[[AudioFX alloc] initWithPath:@"HyperWarp.caf"] autorelease];
	AudioFX *fxLedLum = [[[AudioFX alloc] initWithPath:@"LedLum.caf"] autorelease];
	AudioFX *fxPowerDown = [[[AudioFX alloc] initWithPath:@"PowerDown.caf"] autorelease];
	AudioFX *fxPling = [[[AudioFX alloc] initWithPath:@"Pling.caf"] autorelease];
	AudioFX *fxPock = [[[AudioFX alloc] initWithPath:@"Pock.caf"] autorelease];
	AudioFX *fxPoliceEncounter = [[[AudioFX alloc] initWithPath:@"PoliceEncounter.caf"] autorelease];
	AudioFX *fxRefuel = [[[AudioFX alloc] initWithPath:@"Refuel.caf"] autorelease];
	AudioFX *fxSwitchClick = [[[AudioFX alloc] initWithPath:@"SwitchClick.caf"] autorelease];
	AudioFX *fxTribble = [[[AudioFX alloc] initWithPath:@"Tribble.caf"] autorelease];
	AudioFX *fxWelcomeTo = [[[AudioFX alloc] initWithPath:@"WelcomeTo.caf"] autorelease];
	AudioFX *fxWormJump = [[[AudioFX alloc] initWithPath:@"WormJump.caf"] autorelease];
	AudioFX *fxWormJumpArrive = [[[AudioFX alloc] initWithPath:@"WormJumpArrive.caf"] autorelease];
	AudioFX *fxYourHit = [[[AudioFX alloc] initWithPath:@"YourHit.caf"] autorelease];
	AudioFX *fxCancel = [[[AudioFX alloc] initWithPath:@"Cancel.caf"] autorelease];
	AudioFX *fxBuy = [[[AudioFX alloc] initWithPath:@"Buy.caf"] autorelease];
	AudioFX *fxTransportTo = [[[AudioFX alloc] initWithPath:@"TransportTo.caf"] autorelease];
	
    self.soundArray = [NSMutableArray arrayWithObjects: fxAirWrench,
					   fxCashReg,
					   fxFireLaser,
					   fxHyperWarp,
					   fxLedLum,
					   fxPowerDown,
					   fxPling,
					   fxPock,
					   fxPoliceEncounter,
					   fxRefuel,
					   fxSwitchClick,
					   fxTribble,
					   fxWelcomeTo,
					   fxWormJump,
					   fxWormJumpArrive,
					   fxYourHit,
					   fxCancel,
					   fxBuy,
					   fxTransportTo,
					   nil];
	
	
}

- (void)pauseAudio:(id)sender {
	
}


// Play a note (a sound file) based on an index into the note array
- (void)playSoundWithId:(NSInteger)soundId {
	if ([[NSUserDefaults standardUserDefaults] boolForKey:@"soundEnabled"]) {
		AudioFX *currentSoundEffect = [self.soundArray objectAtIndex:soundId];
		[ currentSoundEffect play ];
	}
}

@end
