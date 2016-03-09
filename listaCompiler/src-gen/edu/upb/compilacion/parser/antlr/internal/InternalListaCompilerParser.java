package edu.upb.compilacion.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.upb.compilacion.services.ListaCompilerGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalListaCompilerParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_INTEGER", "RULE_BOOL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Holi'"
    };
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


        public InternalListaCompilerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalListaCompilerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalListaCompilerParser.tokenNames; }
    public String getGrammarFileName() { return "../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g"; }



     	private ListaCompilerGrammarAccess grammarAccess;
     	
        public InternalListaCompilerParser(TokenStream input, ListaCompilerGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Lista";	
       	}
       	
       	@Override
       	protected ListaCompilerGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleLista"
    // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:67:1: entryRuleLista returns [EObject current=null] : iv_ruleLista= ruleLista EOF ;
    public final EObject entryRuleLista() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLista = null;


        try {
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:68:2: (iv_ruleLista= ruleLista EOF )
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:69:2: iv_ruleLista= ruleLista EOF
            {
             newCompositeNode(grammarAccess.getListaRule()); 
            pushFollow(FOLLOW_ruleLista_in_entryRuleLista75);
            iv_ruleLista=ruleLista();

            state._fsp--;

             current =iv_ruleLista; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLista85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLista"


    // $ANTLR start "ruleLista"
    // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:76:1: ruleLista returns [EObject current=null] : (otherlv_0= 'Holi' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleLista() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:79:28: ( (otherlv_0= 'Holi' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:80:1: (otherlv_0= 'Holi' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:80:1: (otherlv_0= 'Holi' ( (lv_name_1_0= RULE_STRING ) ) )
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:80:3: otherlv_0= 'Holi' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleLista122); 

                	newLeafNode(otherlv_0, grammarAccess.getListaAccess().getHoliKeyword_0());
                
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:84:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:85:1: (lv_name_1_0= RULE_STRING )
            {
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:85:1: (lv_name_1_0= RULE_STRING )
            // ../listaCompiler/src-gen/edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.g:86:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLista139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getListaAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getListaRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLista"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleLista_in_entryRuleLista75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLista85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLista122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLista139 = new BitSet(new long[]{0x0000000000000002L});

}