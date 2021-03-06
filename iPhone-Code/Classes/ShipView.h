//
//  ShipView.h
//
//  Copyright (C) Dead Jim Studios 2009-2010, All rights reserved.
//
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
//

#import <UIKit/UIKit.h>

@interface ShipView : UIView {
	IBOutlet UITextView *label;
	IBOutlet UIImageView *shipImage;
	IBOutlet UILabel *shipName;
	IBOutlet UILabel *shipHull;
	IBOutlet UILabel *shipSize;
	IBOutlet UILabel *shipRange;

}

@property (nonatomic, retain) IBOutlet UITextView *label;
@property (nonatomic, retain) IBOutlet UIImageView *shipImage;
@property (nonatomic, retain) IBOutlet UILabel *shipName;
@property (nonatomic, retain) IBOutlet UILabel *shipHull;
@property (nonatomic, retain) IBOutlet UILabel *shipSize;
@property (nonatomic, retain) IBOutlet UILabel *shipRange;


@end
