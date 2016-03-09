package edu.upb.compilacion.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalListaCompilerLexer extends Lexer {
    public static final int RULE_ID=8;
    public static final int RULE_WS=11;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_BOOL=7;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__13=13;
    public static final int EOF=-1;
    public static final int RULE_INTEGER=6;

    // delegates
    // delegators

    public InternalListaCompilerLexer() {;} 
    public InternalListaCompilerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalListaCompilerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:11:7: ( 'Holi' )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:11:9: 'Holi'
            {
            match("Holi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "RULE_INTEGER"
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:170:14: ( ( '-' )? RULE_INT )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:170:16: ( '-' )? RULE_INT
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:170:16: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:170:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER"

    // $ANTLR start "RULE_BOOL"
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:172:11: ( ( 'true' | 'false' ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:172:13: ( 'true' | 'false' )
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:172:13: ( 'true' | 'false' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                alt2=1;
            }
            else if ( (LA2_0=='f') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:172:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:172:21: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:174:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:174:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:174:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:174:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:174:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:176:10: ( ( '0' .. '9' )+ )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:176:12: ( '0' .. '9' )+
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:176:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:176:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:178:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:180:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:180:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:180:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:180:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:41: ( '\\r' )? '\\n'
                    {
                    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:182:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:184:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:184:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:184:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:186:16: ( . )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:186:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:8: ( T__13 | RULE_INTEGER | RULE_BOOL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=10;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:16: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 3 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:29: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 4 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:39: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 5 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:47: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 6 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:56: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 7 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:68: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 8 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:84: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 9 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:100: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 10 :
                // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:1:108: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\16\1\14\1\17\2\16\1\14\1\uffff\3\14\2\uffff\1\16\2\uffff"+
        "\1\17\2\16\4\uffff\3\16\1\35\1\36\1\16\2\uffff\1\36";
    static final String DFA14_eofS =
        "\40\uffff";
    static final String DFA14_minS =
        "\1\0\1\157\2\60\1\162\1\141\1\101\1\uffff\2\0\1\52\2\uffff\1\154"+
        "\2\uffff\1\60\1\165\1\154\4\uffff\1\151\1\145\1\163\2\60\1\145\2"+
        "\uffff\1\60";
    static final String DFA14_maxS =
        "\1\uffff\1\157\2\71\1\162\1\141\1\172\1\uffff\2\uffff\1\57\2\uffff"+
        "\1\154\2\uffff\1\71\1\165\1\154\4\uffff\1\151\1\145\1\163\2\172"+
        "\1\145\2\uffff\1\172";
    static final String DFA14_acceptS =
        "\7\uffff\1\4\3\uffff\1\11\1\12\1\uffff\1\4\1\2\3\uffff\1\6\1\7"+
        "\1\10\1\11\6\uffff\1\1\1\3\1\uffff";
    static final String DFA14_specialS =
        "\1\2\7\uffff\1\1\1\0\26\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\14\2\13\2\14\1\13\22\14\1\13\1\14\1\10\4\14\1\11\5\14\1"+
            "\2\1\14\1\12\12\3\7\14\7\7\1\1\22\7\3\14\1\6\1\7\1\14\5\7\1"+
            "\5\15\7\1\4\6\7\uff85\14",
            "\1\15",
            "\12\17",
            "\12\20",
            "\1\21",
            "\1\22",
            "\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\0\23",
            "\0\23",
            "\1\24\4\uffff\1\25",
            "",
            "",
            "\1\27",
            "",
            "",
            "\12\20",
            "\1\30",
            "\1\31",
            "",
            "",
            "",
            "",
            "\1\32",
            "\1\33",
            "\1\34",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\37",
            "",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | RULE_INTEGER | RULE_BOOL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_9 = input.LA(1);

                        s = -1;
                        if ( ((LA14_9>='\u0000' && LA14_9<='\uFFFF')) ) {s = 19;}

                        else s = 12;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_8 = input.LA(1);

                        s = -1;
                        if ( ((LA14_8>='\u0000' && LA14_8<='\uFFFF')) ) {s = 19;}

                        else s = 12;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='H') ) {s = 1;}

                        else if ( (LA14_0=='-') ) {s = 2;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 3;}

                        else if ( (LA14_0=='t') ) {s = 4;}

                        else if ( (LA14_0=='f') ) {s = 5;}

                        else if ( (LA14_0=='^') ) {s = 6;}

                        else if ( ((LA14_0>='A' && LA14_0<='G')||(LA14_0>='I' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='e')||(LA14_0>='g' && LA14_0<='s')||(LA14_0>='u' && LA14_0<='z')) ) {s = 7;}

                        else if ( (LA14_0=='\"') ) {s = 8;}

                        else if ( (LA14_0=='\'') ) {s = 9;}

                        else if ( (LA14_0=='/') ) {s = 10;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 11;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='(' && LA14_0<=',')||LA14_0=='.'||(LA14_0>=':' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='{' && LA14_0<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}