package TTTModule;


/**
* TTTModule/_TTTStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from TTTModule.idl
* Wednesday, 10 March 2021 10:57:46 o'clock IST
*/

public class _TTTStub extends org.omg.CORBA.portable.ObjectImpl implements TTTModule.TTT
{

  public int howFull (String boardStr)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("howFull", true);
                $out.write_string (boardStr);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return howFull (boardStr        );
            } finally {
                _releaseReply ($in);
            }
  } // howFull

  public boolean isValidMove (int move, String boardStr)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("isValidMove", true);
                $out.write_long (move);
                $out.write_string (boardStr);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return isValidMove (move, boardStr        );
            } finally {
                _releaseReply ($in);
            }
  } // isValidMove

  public int serverMove (String boardStr)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("serverMove", true);
                $out.write_string (boardStr);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return serverMove (boardStr        );
            } finally {
                _releaseReply ($in);
            }
  } // serverMove

  public int determineWinner (String boardStr)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("determineWinner", true);
                $out.write_string (boardStr);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return determineWinner (boardStr        );
            } finally {
                _releaseReply ($in);
            }
  } // determineWinner

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:TTTModule/TTT:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _TTTStub
