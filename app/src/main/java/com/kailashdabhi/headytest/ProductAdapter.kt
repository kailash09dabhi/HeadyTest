package com.kailashdabhi.headytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kailashdabhi.headytest.ProductAdapter.ViewHolder
import com.kailashdabhi.headytest.data.database.Product
import kotlinx.android.synthetic.main.item_product.view.category
import kotlinx.android.synthetic.main.item_product.view.dateAdded
import kotlinx.android.synthetic.main.item_product.view.name
import kotlinx.android.synthetic.main.item_product.view.orderCount
import kotlinx.android.synthetic.main.item_product.view.shareCount
import kotlinx.android.synthetic.main.item_product.view.viewCount

class ProductAdapter(val items: List<Product>) :
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
    holder.category.text = "Category - " + product.category
    holder.shareCount.text = "Share count - " + product.shareCount
    holder.viewCount.text = "View count - " + product.viewCount
    holder.orderCount.text = "Order count - " + product.orderCount
  }

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.name
    val category = view.category
    val viewCount = view.viewCount
    val orderCount = view.orderCount
    val shareCount = view.shareCount
    val dateAdded = view.dateAdded
  }
}
