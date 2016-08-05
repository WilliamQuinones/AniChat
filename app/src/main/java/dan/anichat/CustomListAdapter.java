package dan.anichat;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private AppFilter filter;
    private final ArrayList<String> itemname;
    private final ArrayList<Integer> imgid;

    public CustomListAdapter(Activity context, ArrayList<String> itemname, ArrayList<Integer> imgid) {
        super(context, R.layout.animelistcustomadapter, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname = new ArrayList<String>();
        this.itemname.addAll(itemname);
        this.imgid = new ArrayList<Integer>();
        this.imgid.addAll(imgid);

    }

    public View getView(int position,View view,ViewGroup parent) {



        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.animelistcustomadapter, null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView txt = (TextView) rowView.findViewById(R.id.textView1);

        imageView.setImageResource(imgid.get(position));
        txt.setText(itemname.get(position));
        return rowView;

    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new AppFilter();
        }
        return filter;
    }




    private class AppFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence chars) {
            String filterSeq = chars.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (filterSeq != null && filterSeq.length() > 0) {
                ArrayList<String> filter = new ArrayList();

                for (int i = 0; i < itemname.size(); i++ ) {
                    String temp = itemname.get(i);
                    // the filtering itself:
                    if (temp.toString().toLowerCase().contains(filterSeq))
                        filter.add(temp);
                }
                result.count = filter.size();
                result.values = filter;
            } else {
                // add all objects
                synchronized (this) {
                    result.values = itemname;
                    result.count = itemname.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            // NOTE: this function is *always* called from the UI thread.
            ArrayList<String> filtered = (ArrayList<String>) results.values;
            notifyDataSetChanged();
            clear();
            for (int i = 0, l = filtered.size(); i < l; i++)
                add(filtered.get(i));
            notifyDataSetInvalidated();

        }
    }

}







