package io.github.droidknights.droidknightsgoods.view.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.github.droidknights.droidknightsgoods.listener.OnLottoClickListener
import io.github.droidknights.droidknightsgoods.model.Lotto
import io.github.droidknights.droidknightsgoods.view.main.adapter.holder.ResultViewHolder
import io.github.droidknights.droidknightsgoods.view.main.adapter.model.ResultAdapterContract

/**
 * Created by tae-hwan on 23/03/2017.
 */

class ResultAdapter(val context: Context) : RecyclerView.Adapter<ResultViewHolder>(), ResultAdapterContract.Model, ResultAdapterContract.View {

    val list = ArrayList<Lotto>()

    private lateinit var onLottoClickListener: OnLottoClickListener

    override fun setOnClickListener(onClick: (Int, Boolean) -> Unit) {
        onLottoClickListener = object : OnLottoClickListener {
            override fun onClickItem(premiumIdx: Int, isHide: Boolean) {
                onClick(premiumIdx, isHide)
            }
        }
    }

    override fun onBindViewHolder(holder: ResultViewHolder?, position: Int) {
        holder?.onBindView(position, list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
        = ResultViewHolder(context, parent, onLottoClickListener)

    override fun getItemCount() = list.size

    override fun clear() {
        list.clear()
    }

    override fun addItem(lotto: Lotto) {
        list.add(lotto)
    }

    override fun notifyDataChange() {
        notifyDataSetChanged()
    }
}