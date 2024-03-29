/**
 * Copyright 2009 Friedrich Schäuffelhut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package de.schaeuffelhut.android.openvpn.installer;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import de.schaeuffelhut.android.openvpn.util.Util;

public final class HelpDialog {
	private HelpDialog() {
	}

	public final static Dialog makeDialog(Context context) {
		
		String string = Util.getAssetAsString(context, "help.html");
		string = string.replace( "$version", Util.applicationVersionName(context) );
		Spanned message = Html.fromHtml( string );

		TextView textView = new TextView(context);
		textView.setText(message, BufferType.SPANNABLE );
		textView.setMovementMethod( LinkMovementMethod.getInstance() );

		ScrollView scrollView = new ScrollView(context);
		scrollView.addView( textView );

		final Dialog dialog = new AlertDialog.Builder(context).
		setTitle( R.string.help_dialog_title ).
		setView( scrollView ).
		setNeutralButton( "OK", null ).
		setCancelable(true).
		setIcon( android.R.drawable.ic_dialog_info).
		create();
		
		return dialog;
	}
}
