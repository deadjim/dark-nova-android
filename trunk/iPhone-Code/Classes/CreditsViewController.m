// 
//  CreditsViewController.m
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

#import "CreditsViewController.h"
#import "AppDelegate.h"

@implementation CreditsViewController

@synthesize navBar, webView, location;

-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
}

-(void)dealloc {
	[navBar release];
	[webView release];
	[location release];
	
	[super dealloc];	
}

#pragma mark -
#pragma mark Compose Mail
-(void)displayComposerSheet
{
	MFMailComposeViewController *picker = [[MFMailComposeViewController alloc] init];
	picker.mailComposeDelegate = self;
	
	switch (emailType) {
		case 0: {
			[picker setSubject:[NSString stringWithFormat:@"HyperWARP Support"]];
			NSArray *toRecipients = [NSArray arrayWithObject:@"support@darknova.net"]; 
			[picker setToRecipients:toRecipients];
			NSString *emailBody = @"> Please provide as much detail as you can <  \n\n\n\n";
			[picker setMessageBody:emailBody isHTML:NO];
		}
			break;
		case 1: {
			[picker setSubject:[NSString stringWithFormat:@"HyperWARP - great game!"]];
			NSString *emailBody = @"Check out this awesome iPhone game, it's called Dark Nova.\nhttp://darknova.net/hyperwarp.html";
			[picker setMessageBody:emailBody isHTML:NO];
		}
			break;
		case 2: { 
			[picker setSubject:[NSString stringWithFormat:@"HyperWARP - Quick Start"]];
			NSString *emailBody = @"Attached is the Quick Start PDF.\nhttp://darknova.net/hyperwarp.html";
			[picker setMessageBody:emailBody isHTML:NO];
			NSString *pdfFilePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/QuickStart.pdf"];
			NSData *myTXT = [NSData dataWithContentsOfFile:pdfFilePath];
			[picker addAttachmentData:myTXT mimeType:@"text/plain" fileName:@"QuickStart.pdf"];			
		}
			break;
		case 3: { 
			[picker setSubject:[NSString stringWithFormat:@"HyperWARP - Users Guide"]];
			NSString *emailBody = @"Attached is the Users Guide PDF.\nhttp://darknova.net/hyperwarp.html";
			[picker setMessageBody:emailBody isHTML:NO];
			NSString *pdfFilePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/UsersGuide.pdf"];
			NSData *myTXT = [NSData dataWithContentsOfFile:pdfFilePath];
			[picker addAttachmentData:myTXT mimeType:@"text/plain" fileName:@"UsersGuide.pdf"];			
		}
			break;
		default:
			break;
	}
	
	NSString *iconpath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/AppIcon.png"];
    NSData *icondata = [NSData dataWithContentsOfFile:iconpath];
	[picker addAttachmentData:icondata mimeType:@"image/png" fileName:@"AppIcon"];
	
	[self presentModalViewController:picker animated:YES];
    [picker release];
}


- (void)mailComposeController:(MFMailComposeViewController*)controller didFinishWithResult:(MFMailComposeResult)result error:(NSError*)error {	

	[self dismissModalViewControllerAnimated:YES];
	
}


-(IBAction)chooseEmailAction {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Which Type of Email?" message:@"Please select an option below." delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Developer", @"Tell Others", @"Quick Start", @"Users Guide", nil];
	[alert show];
	[alert release];
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  {
	
	if (buttonIndex == 1) {
		emailType = 0;
		[self displayComposerSheet];
	}
	if (buttonIndex == 2) {
		emailType = 1;
		[self displayComposerSheet];	
	}
	if (buttonIndex == 3) {
		emailType = 2; 
		[self displayComposerSheet];	
	}
	if (buttonIndex == 4) {
		emailType = 3; 
		[self displayComposerSheet];	
	}
	
}

-(void)viewDidLoad {
	[super viewDidLoad];
	self.title = NSLocalizedString(@"Credits", @"");

	[webView loadRequest:[NSURLRequest requestWithURL:location]];
}


- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

@end
