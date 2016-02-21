
package cn.hi321.browser.model.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import cn.hi321.browser2.R;

/**
 * Adapter for suggestions.
 */
public class UrlSuggestionCursorAdapter extends SimpleCursorAdapter {

	public static final String URL_SUGGESTION_ID = "_id";
	public static final String URL_SUGGESTION_TITLE = "URL_SUGGESTION_TITLE";
	public static final String URL_SUGGESTION_URL = "URL_SUGGESTION_URL";
	public static final String URL_SUGGESTION_TYPE = "URL_SUGGESTION_TYPE";
	
	/**
	 * Constructor.
	 * @param context The context.
	 * @param layout The layout.
	 * @param c The Cursor. 
	 * @param from Input array.
	 * @param to Output array.
	 */
	public UrlSuggestionCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {		
		super(context, layout, c, from, to);		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View superView = super.getView(position, convertView, parent);
		
		ImageView iconView = (ImageView) superView.findViewById(R.id.AutocompleteImageView);

		int resultType;
		try {			
			resultType = Integer.parseInt(getCursor().getString(getCursor().getColumnIndex(URL_SUGGESTION_TYPE)));
		} catch (Exception e) {
			resultType = 0;
		}
		
		switch (resultType) {
		case 1: iconView.setImageResource(R.drawable.ic_tab_history_unselected); break;
		case 2: iconView.setImageResource(R.drawable.ic_tab_bookmarks_unselected); break;
		case 3: iconView.setImageResource(R.drawable.ic_tab_weave_unselected); break;
		default: break;
		}
		
		return superView;
	}
	
	

}
