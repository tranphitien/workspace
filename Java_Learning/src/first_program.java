

enum Size
{
	SMALL,
	MEDIUM,
	LARGE
}

class FreshJuice {
	enum FreshJuiceSize {
		SMALL,
		MEDIUM,
		LARGE
	}
	
	FreshJuiceSize size;
	Size size2;
}

class Count
{
	static int count;
	
	static
	{
		count = 0;
		System.out.println("Initialize count value to " + count);
	}
	
	Count ()
	{
		count++;
		System.out.println("Count = " + count);
	}
	
	static void reset()
	{
		count = 0;
	}
}

class arrayUtil
{
	static int[] arrayReserver(int[] array)
	{
		int[] result = new int[array.length];
		
		System.out.println("Input=");
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.printf(array[i] + " ");
		}
		
		System.out.println();
		
		for (int i = 0, j = array.length - 1; i < array.length; i++, j--)
		{
			result[j] = array[i];
		}
		
		System.out.println("Output=");
		
		for (int i: result)
		{
			System.out.printf(i + " ");
		}
		
		return result;
	}	
}

public class first_program extends Count
{
	public first_program (String name)
	{
		System.out.println("input name: " + name);
	}
	
	public first_program()
	{
		System.out.println("Constructor NULL");
	}
	
	public static void main(String []args)
	{
		System.out.println("Hello world");
		
		FreshJuice juice = new FreshJuice();
		
		juice.size = FreshJuice.FreshJuiceSize.LARGE;
		juice.size2 = Size.SMALL;
		
		System.out.println("Size: " + juice.size + " Size2: " + juice.size2);
		
		first_program f_p = new first_program();
		
		/* Count examination */
		Count cnt1 = new Count();
		Count cnt2 = new Count();
		Count.reset();
		Count cnt3 = new Count();
		
		String str = "abc";
		boolean result = str instanceof String;
		System.out.println(result);
		
		Count cnt = new first_program();
		result = cnt instanceof Count;
		System.out.println(result);
		result = cnt instanceof first_program;
		System.out.println(result);
		
		int[] numbers = { 0, 2, 4, 6, 8};
		String[] names = {"An", "Binh"};
		
		for (int x = 0; x < 20; x++)
		{
			System.out.print(x);
		}
		
		System.out.println();
		
		for (int x : numbers)
		{
			System.out.print(x + ",");
		}
		
		System.out.print("\n");
		
		for (String x : names)
		{
			System.out.print(x + ",");
		}
		
		System.out.println();
		
		char[] helloArray = { 'H', 'e', 'l', 'l', 'o'};
		String helloString = new String(helloArray);
		System.out.println(helloString + "\t" + ": length = " + helloString.length());
		System.out.println(helloString.concat(" World"));
		
		String fs;
		float n = 2.56f;
		double m = 45;
		String k = "adf";
		
		fs = String.format("Float number: %f \n" +
							"Integer number: %d \n" +
							"String value: %s", n, (int)m, k);
		
		System.out.println(fs);
		
		String test_string = "abc";
		char[] word = {'a', 'b', 'c', 'd'};
		String test2_string = new String(word);
		
		System.out.println(test_string);
		System.out.println(test2_string + ", length = " + test2_string.length());
		System.out.println(test_string.concat(test2_string.concat("ght".concat("bnm"))));
		
		int[] array = {0, 2, 4, 6, 8, 9};
		int[] r_array;
		r_array = arrayUtil.arrayReserver(array);
	}
}
