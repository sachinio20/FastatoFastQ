
package dna;

import java.io.*; 
import java.util.*;


public class FileConverter 
{
	private File fastq;
	private File fasta;
	
	public FileConverter(File fq, File fa) {
		this.fastq = fq;
		this.fasta = fa;
	}
	//
	// Writes a fasta file consisting of conversion of all records from the fastq with
	// sufficient quality, valid formatting and unique defline.
	//
	public void convert() throws IOException
	{
		// Build chain of readers.
		FileReader fr = new FileReader(this.fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(this.fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		// While loop that reads fastq files until it reports null, only writes valid fasta files
		boolean done = false;
		while(!done) {
				try {
					FastqRecord rec = fqr.readRecord();
					if(rec == null) {
						done = true;
					}
					
					else if (!rec.qualityIsLow()){
						FastaRecord fa = new FastaRecord(rec);
						faw.writeRecord(fa);
					}
					
				}
				catch(RecordFormatException x) {
					System.out.println(x.getMessage());
				}
		}
				
		
		// Close fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}
	
		
	
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			System.out.println("Test 1");
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
			System.out.println("Test 2");
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
