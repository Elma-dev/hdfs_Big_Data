# HDFS_Big_Data 
## ❕About Repo
In this repository, we learn about Hadoop MapReduce. As we know, the best way to learn is through application. That's why in this repository, we have two applications. 
  * The first one is about calculating the total purchase in each city with the data structured like this: (Date, City, Product, Price).
  * The second application is about calculating how many requests a machine makes and determining how many of those requests are successful based on server logs.
## 📚Prerequisite
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Hadoop](https://img.shields.io/badge/Apache%20Hadoop-66CCFF.svg?style=for-the-badge&logo=Apache-Hadoop&logoColor=black)

## 📝Explanation
```
HDFS divides large files into smaller blocks, typically 128 MB or 256 MB in size.
These blocks are distributed across multiple machines (nodes) in a Hadoop cluster.
This distribution allows HDFS to store and process large files efficiently.
```
    
![‎bdata ‎001](https://github.com/Elma-dev/hdfs_Big_Data/assets/67378945/82f42780-e7dc-4460-ab55-ac1ac73174d3)

```
The mapper function is a user-defined function that is applied to each input record. It takes the input
record as its argument and produces a set of key-value pairs as output. These key-value pairs are often
used to group and sort the data for the subsequent reduce phase.
```

![‎bdata ‎002](https://github.com/Elma-dev/hdfs_Big_Data/assets/67378945/90635e1d-37da-4135-89e9-a7bec5a30e01)


```java
public class VentMapper extends Mapper<LongWritable, Text,Text, DoubleWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DoubleWritable>.Context context) throws IOException, InterruptedException {

        String[] row = value.toString().split(",");
        String city=row[1];
        Double price=Double.parseDouble(row[3]);
        context.write(new Text(city),new DoubleWritable(price));
    }
}

```

```
After the mappers have processed their respective input data, the MapReduce framework takes care of shuffling
and sorting the intermediate key-value pairs. This ensures that all key-value pairs with the same key end up
together, making it easier for the reducer to process related data.
```

![‎bdata ‎003](https://github.com/Elma-dev/hdfs_Big_Data/assets/67378945/088ef8e4-36b7-401e-9529-25816dadbeee)

```
The sorted and grouped key-value pairs are then passed to the reducer. Reducers process these groups of data
based on the keys and apply a user-defined reduce function to perform further computation or aggregation.
```

![‎bdata ‎004](https://github.com/Elma-dev/hdfs_Big_Data/assets/67378945/41b10f56-1cf6-4935-8209-f5c5a72c5d74)

```java
public class VentReduce extends Reducer<Text, DoubleWritable,Text, DoubleWritable> {
    @Override
    protected void reduce(Text key, Iterable<DoubleWritable> values, Reducer<Text, DoubleWritable, Text, DoubleWritable>.Context context) throws IOException, InterruptedException {
        double p=0;
        Iterator<DoubleWritable> iterator = values.iterator();
        while (iterator.hasNext()){
           p+= iterator.next().get();
        }
        context.write(key,new DoubleWritable(p));
    }
}
```

## ❇️ Application Result
<table>
 <th>
  <td><img width="691" alt="Screen Shot 2023-10-24 at 22 35 55" src="https://github.com/Elma-dev/hdfs_Big_Data/assets/67378945/5d657a0c-3515-4783-9098-a935f3efc4f7"></td>
 <td><img width="691" alt="Screen Shot 2023-10-24 at 22 35 55" src="https://github.com/Elma-dev/hdfs_Big_Data/assets/67378945/66791bc8-07e1-4dd9-887b-60a835f6c7f5"></td>
 </th>
</table>






