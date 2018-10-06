package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqRecord.
//


public class FastqReader 
{
	private BufferedReader br;
	
	public FastqReader(BufferedReader mybr) {
		br = mybr;
	}
	
	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		
		String defline = br.readLine();
		if(defline!=null) {
			String sequence = br.readLine();
			String plus = br.readLine();
			String quality = br.readLine();
				FastqRecord returnable = new FastqRecord(defline, sequence,quality);
				return returnable;
			}
		else {
			
			return null;

}
	}
}
