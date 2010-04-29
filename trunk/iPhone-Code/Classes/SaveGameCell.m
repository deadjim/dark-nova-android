// 
//  SaveGameCell.m
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

#import "SaveGameCell.h"

#define kCellHeight	25.0

NSString *kDisplayCell_ID = @"DisplayCell_ID";


@implementation SaveGameCell

@synthesize nameLabel, infoLabel;

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {
	
    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {
		//self.selectionStyle = UITableViewCellSelectionStyleNone;
		self.selectionStyle = UITableViewCellSelectionStyleGray;

		CGRect aRect = CGRectMake(8.0, -6.0, self.contentView.bounds.size.width, self.contentView.bounds.size.height);
		nameLabel = [[UILabel alloc] initWithFrame:aRect];
		nameLabel.backgroundColor = [UIColor clearColor];
		nameLabel.opaque = NO;
		nameLabel.textColor = [UIColor blackColor];
		nameLabel.highlightedTextColor = [UIColor blackColor];
		nameLabel.font = [UIFont boldSystemFontOfSize:18];
		[self.contentView addSubview:nameLabel];
		
		CGRect newRect = CGRectMake(8.0, 18.0, self.contentView.bounds.size.width, self.contentView.bounds.size.height);
		infoLabel = [[UILabel alloc] initWithFrame:newRect];
		infoLabel.backgroundColor = [UIColor clearColor];
		infoLabel.opaque = NO;
		infoLabel.numberOfLines = 2;
		infoLabel.textColor = [UIColor grayColor];
		infoLabel.highlightedTextColor = [UIColor blackColor];
		infoLabel.font = [UIFont systemFontOfSize:10];
		[self.contentView addSubview:infoLabel];
		
    }
    return self;
}


- (void)setSelected:(BOOL)selected animated:(BOOL)animated {

    [super setSelected:selected animated:animated];
	
}


- (void)dealloc {
	[infoLabel release];
	[nameLabel release];
    [super dealloc];

}


@end
