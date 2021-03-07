package TTTModule;


/**
* TTTModule/TTTHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from TTTModule.idl
* Friday, 5 March 2021 14:18:47 o'clock IST
*/

abstract public class TTTHelper
{
  private static String  _id = "IDL:TTTModule/TTT:1.0";

  public static void insert (org.omg.CORBA.Any a, TTTModule.TTT that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static TTTModule.TTT extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (TTTModule.TTTHelper.id (), "TTT");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static TTTModule.TTT read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_TTTStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, TTTModule.TTT value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static TTTModule.TTT narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof TTTModule.TTT)
      return (TTTModule.TTT)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      TTTModule._TTTStub stub = new TTTModule._TTTStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static TTTModule.TTT unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof TTTModule.TTT)
      return (TTTModule.TTT)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      TTTModule._TTTStub stub = new TTTModule._TTTStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
