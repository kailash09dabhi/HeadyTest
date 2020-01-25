package com.kailashdabhi.headytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kailashdabhi.headytest.ProductAdapter.ViewHolder
import com.kailashdabhi.headytest.data.model.Product
import kotlinx.android.synthetic.main.item_product.view.dateAdded
import kotlinx.android.synthetic.main.item_product.view.name

class ProductAdapter(private val items: List<Product>) :
  RecyclerView.Adapter<ViewHolder>() {

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    return ViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
    )
  }

  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {
    val product = items[position]
    if (product.name.isNullOrEmpty()) holder.name.visibility = View.GONE else {
      holder.name.visibility = View.VISIBLE
      holder.name.text = product.name
    }
    holder.dateAdded.text = product.dateAdded
  }

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val dateAdded = view.dateAdded
    val name = view.name
  }
}
