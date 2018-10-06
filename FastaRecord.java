

package dna;


public class FastaRecord implements DNARecord 
{	
	//
	// Add a precondition check: throw RecordGFormatException if the 1st char of the defline is 
	// not '>'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	private String defline;
	private String sequence;
	
	FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		String first = defline.substring(0,1);
		
		if(first.equals(">") == false) {
			throw new RecordFormatException("The file does not start with the character >");
			
		}
		else {
			this.defline = defline;
			this.sequence = sequence;
		}
	}
	// Initialize defline and sequence from the input record. The defline should be the
		// defline of the fastq record, but with a '>' in the first position rather than a '@'.
		// uses the replaceFirst() method of String API
	
	public FastaRecord(FastqRecord q) {
		
	defline = q.getDefline().replaceFirst("@",">");
	sequence = q.getSequence();
	
	}
		

	// 
	// Provide the 2 methods that satisfy the interface.
	//
	public String getDefline() {
		return this.defline;
		
	}
	
	public String getSequence() {
		return this.sequence;
	}
	
	
	//
	// Provide an equals() method. 
	//
	
	public boolean equals(Object y) {
		FastaRecord that = (FastaRecord)y;
		if(this.defline.equals(that.getDefline()) == false) {
			return false;
		}
		else {
			if(this.sequence.equals(that.getSequence()) == false) {
				return false;
			}
			else {
				return true;
			}
		}
	}

	//
	// Provide a hashCode() method that returns the sum of the hashcodes of 
	// defline and sequence.
	//
	
	public int hashCode() {
		return defline.hashCode()+ sequence.hashCode();
	}
}
