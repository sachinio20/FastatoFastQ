
package dna;

//
// FastqRecord contains the defline, sequence, and quality string, not the + line
// from a record in a fastq file.
//

public class FastqRecord implements DNARecord 
{
	//
	//  throws RecordFormatException if the 1st char of the defline is 
	// not '@'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	private String defline;
	private String sequence;
	private String quality;
	
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		String firstchar = defline.substring(0, 1);
		
		if(firstchar.equals("@") == false)
		{
			throw new RecordFormatException("The fastq file you are using starts with an invalid char");
			
		}
		else
		{
			this.defline = defline;
			this.sequence = sequence;
			this.quality = quality;
		}
	}
	
	
	// 
	// Provide the 2 methods that satisfy the interface.
	//getDefline() returns a defline
	//getSequence() returns the sequence of the record

	public String getDefline() {
		return this.defline;
		
	}
	
	public String getSequence() {
		return this.sequence;
	}
	

	//
	// Provide an equals() method that checks for deep equality of all 3 instance variables. 
	// When checking string variables, be sure to do it like this:  
	//              this.defline.equals(that.defline) 
	// and not like this:  
	//              this.defline == that.defline
	//
	
	public boolean equals(Object x)  {
		FastqRecord q = (FastqRecord)x;
		if(this.defline.equals(q.defline)==false) {
			return false;
		}
		else {
			if(this.sequence.equals(q.sequence) == false) {
				return false;
			}
			else {
				if(this.quality.equals(q.quality) == false) {
					return false;
				}
				else {
					return true;
				}
			}
		}
	}

	//
	// Checks the 4th line of every fastq file to see if it satsifies the minimum quality
	//
	public boolean qualityIsLow()
	
	{
		String test1 = "#";
		String test2 ="$";
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < quality.length();i++) {
			if(test1.contains(quality.substring(i, i+1))==true) {
				count1++;
			}
			else if(test2.contains(quality.substring(i, i+1))==true) {
				count2++;
			}
		}
		
		if(count1 > 0 && count2 >0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//
	// Complete this. Return the sum of the hash codes of defline, sequence, and quality.
	//
	public int hashCode()
	{
		return defline.hashCode() + quality.hashCode() + sequence.hashCode();
	}
}
