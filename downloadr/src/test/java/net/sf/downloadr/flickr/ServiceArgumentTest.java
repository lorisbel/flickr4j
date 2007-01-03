package net.sf.downloadr.flickr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

public class ServiceArgumentTest extends TestCase {
	@SuppressWarnings("unchecked")
	public void testServiceArgumentOrder() {
		ServiceArgument arg1 = new ServiceArgument("foo", "1");
		ServiceArgument arg2 = new ServiceArgument("baz", "2");
		ServiceArgument arg3 = new ServiceArgument("bar", "3");

		List args = Arrays.asList(new ServiceArgument[] {arg1, arg2, arg3});
		Collections.sort(args);
		assertSame(arg3, args.get(0));
	}

	public void testStringRepresentation() {
		ServiceArgument arg = new ServiceArgument("foo", "1");
		assertEquals("foo=1", arg.toString());

		arg = new ServiceArgument("method", "flickr.auth.getFrob");
		assertEquals("method=flickr.auth.getFrob", arg.toString());
	}
}
