package com.example.smartvalve

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class LogAdapter(val c: Context, val layoutList: Int, val listItem: ArrayList<LogVO>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var v:View? = convertView
        val inflater = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        v = inflater.inflate(layoutList, null)

        var no_view:TextView = v.findViewById(R.id.no_content)
        var status_valve_view:TextView = v.findViewById(R.id.status_valve_content)
        var status_knob_view:TextView = v.findViewById(R.id.status_knob_content)
        var on_time_valve_view:TextView = v.findViewById(R.id.on_time_valve_content)
        var off_time_valve_view:TextView = v.findViewById(R.id.off_time_valve_content)

        no_view.text = listItem.get(position).num.toString()
        status_valve_view.text = listItem.get(position).statusOfValve.toString()
        status_knob_view.text = listItem.get(position).statusOfKnob.toString()
        on_time_valve_view.text = listItem.get(position).onTimeValve.toString()
        off_time_valve_view.text = listItem.get(position).offTimeValve.toString()

        return v
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return listItem.size
    }

}
