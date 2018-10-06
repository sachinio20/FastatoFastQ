
package dna;

import java.io.*;


//
// Writes a fasta record to a print writer.
//


public class FastaWriter 
{
	private PrintWriter thePrintWriter;
	
	public FastaWriter(PrintWriter x ) {
		this.thePrintWriter = x;
	}
	
	// Write the rec as 2 separate lines: first the defline, then the sequence.
	// Uses the printwriter API to write the fasta files on separate lines
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
}

