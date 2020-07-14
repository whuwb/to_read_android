package com.lucine.toread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lucine.toread.model.ToReadItem;
import com.lucine.toread.model.ToReads;

public class ToReadsAdapter extends BaseAdapter {
    private final Context mContext;
    private final ToReads toReads;

    public ToReadsAdapter(Context context, ToReads toReads) {
        this.mContext = context;
        this.toReads = toReads;
    }

    @Override
    public int getCount() {
        return this.toReads.GetItems().size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ToReadItem toReadItem = this.toReads.GetItems().get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_toread, null);
        }

        final TextView nameTextView = (TextView) convertView.findViewById(R.id.textview_read_name);
        final TextView doubanTextView = (TextView) convertView.findViewById(R.id.textview_read_douban);

        nameTextView.setText(toReadItem.GetTitle());
        doubanTextView.setText(toReadItem.GetDoubanStar().toString());

        return convertView;
    }
}
