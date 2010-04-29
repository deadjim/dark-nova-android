//
//  SoundManager.h
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

#import <UIKit/UIKit.h>
#import "AudioFX.h"

enum kSystemSound
{
	kAirWrench = 0,
	kCashReg,
	kFireLaser,
	kHyperWarp,
	kLedLum,
	kPowerDown,
	kPling,
	kPock,
	kPoliceEncounter,
	kRefuel,
	kSwitchClick,
	kTribble,
	kWelcomeTo,
	kWormJump,
	kWormJumpArrive,
	kYourHit,
	kCancel,
	kBuy,
	kTransportTo
};


@interface SoundManager : NSObject {

	NSMutableArray      *soundArray;
}

@property (nonatomic, retain) NSMutableArray *soundArray;

+ (id)sharedSound;
- (void)startAudio:(id)sender;
- (void)pauseAudio:(id)sender;
- (void)playSoundWithId:(NSInteger)soundId;

@end
