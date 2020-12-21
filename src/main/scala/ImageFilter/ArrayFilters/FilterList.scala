package ImageFilter.ArrayFilters

import scala.reflect.ClassTag

class FilterList(seq: Seq[Filter]) extends Filter {
  override def filter[T: ClassTag](arr: Array[Array[T]]): Array[Array[T]] = {
    var out = arr.map(_.clone())
    for(filter <- seq){
      out = filter.filter(out)
    }
    out
  }
}
