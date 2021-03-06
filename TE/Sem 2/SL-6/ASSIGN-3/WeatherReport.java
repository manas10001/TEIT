package report;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WeatherReport {
	public static void main(String args[]) throws Exception {
		
		Configuration c = new Configuration();
		
		String[] files=new GenericOptionsParser(c,args).getRemainingArgs();
		
		Path input=new Path(files[0]);
		
		Path output=new Path(files[1]);
		
		Job j=new Job(c,"weather-reporter");
		
		j.setJarByClass(WeatherReport.class);
		j.setMapperClass(MapWeather.class);
		j.setReducerClass(ReduceWeather.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(j, input);
		FileOutputFormat.setOutputPath(j, output);
		System.exit(j.waitForCompletion(true)?0:1);
		
	}
	
	public static class MapWeather extends Mapper<LongWritable, Text, Text, IntWritable>{
		public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException
		{
			String content = value.toString();
			String lines[]  = content.split("\n");
			
			String year = null;
			String temp = null;
			
			IntWritable val = null;
			Text opkey = null;
			
			for(String line : lines) {
				year = line.substring(15,19);
				temp = line.substring(87,92);
				
				opkey = new Text(year);
				val = new IntWritable(Integer.parseInt(temp));
				
				con.write(opkey,val);
			}
			
		}
	}
	
	public static class ReduceWeather extends Reducer<Text, IntWritable, Text, IntWritable>
	{
		String Wmin = null;
		String Wmax = null;
		Text Seperator = new Text("-----------------------");
		int min = 9999;
		int max = 0;
		public void reduce(Text word, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException
		{
			int norc = 1;	//to count no of records
			int sum = 0;
			for(IntWritable value : values) {
				//con.write(word, value);
				sum += value.get();
				norc++;
			}
			
			sum = sum/norc;
			
			if(sum < min) {
				Wmin = word.toString();
				min = sum;
			}
			if(sum > max) {
				Wmax = word.toString();
				max = sum;
			}
			
			con.write(word, new IntWritable(sum));
			
		}
		
		protected void cleanup(Context context) throws IOException, InterruptedException {
			context.write(Seperator, new IntWritable(1));
			context.write(new Text(Wmax), new IntWritable(max));
			context.write(new Text(Wmin), new IntWritable(min));
	    }
		
	}
	
	
	
}
