package org.tweaktalent.hadoop.airline;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AirLineReduce extends Reducer<Text,IntWritable,Text,IntWritable> {

	public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
		System.out.println("Key:"+ key.toString() + " Values:"+values.toString());
		int sum =0;
		for(IntWritable value:values) {
			sum+= value.get();
		}
		context.write(key, new IntWritable(sum));
	}
}
