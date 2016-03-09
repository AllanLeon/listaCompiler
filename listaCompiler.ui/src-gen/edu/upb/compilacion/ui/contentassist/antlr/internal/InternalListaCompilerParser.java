package edu.upb.compilacion.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import edu.upb.compilacion.services.ListaCompilerGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalListaCompilerParser extends AbstractInternalContentAssistParser {
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
    public String getGrammarFileName() { return "../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g"; }


     
     	private ListaCompilerGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ListaCompilerGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleLista"
    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:60:1: entryRuleLista : ruleLista EOF ;
    public final void entryRuleLista() throws RecognitionException {
        try {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:61:1: ( ruleLista EOF )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:62:1: ruleLista EOF
            {
             before(grammarAccess.getListaRule()); 
            pushFollow(FOLLOW_ruleLista_in_entryRuleLista61);
            ruleLista();

            state._fsp--;

             after(grammarAccess.getListaRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLista68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLista"


    // $ANTLR start "ruleLista"
    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:69:1: ruleLista : ( ( rule__Lista__Group__0 ) ) ;
    public final void ruleLista() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:73:2: ( ( ( rule__Lista__Group__0 ) ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:74:1: ( ( rule__Lista__Group__0 ) )
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:74:1: ( ( rule__Lista__Group__0 ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:75:1: ( rule__Lista__Group__0 )
            {
             before(grammarAccess.getListaAccess().getGroup()); 
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:76:1: ( rule__Lista__Group__0 )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:76:2: rule__Lista__Group__0
            {
            pushFollow(FOLLOW_rule__Lista__Group__0_in_ruleLista94);
            rule__Lista__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getListaAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLista"


    // $ANTLR start "rule__Lista__Group__0"
    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:90:1: rule__Lista__Group__0 : rule__Lista__Group__0__Impl rule__Lista__Group__1 ;
    public final void rule__Lista__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:94:1: ( rule__Lista__Group__0__Impl rule__Lista__Group__1 )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:95:2: rule__Lista__Group__0__Impl rule__Lista__Group__1
            {
            pushFollow(FOLLOW_rule__Lista__Group__0__Impl_in_rule__Lista__Group__0128);
            rule__Lista__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Lista__Group__1_in_rule__Lista__Group__0131);
            rule__Lista__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lista__Group__0"


    // $ANTLR start "rule__Lista__Group__0__Impl"
    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:102:1: rule__Lista__Group__0__Impl : ( 'Holi' ) ;
    public final void rule__Lista__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:106:1: ( ( 'Holi' ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:107:1: ( 'Holi' )
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:107:1: ( 'Holi' )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:108:1: 'Holi'
            {
             before(grammarAccess.getListaAccess().getHoliKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Lista__Group__0__Impl159); 
             after(grammarAccess.getListaAccess().getHoliKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lista__Group__0__Impl"


    // $ANTLR start "rule__Lista__Group__1"
    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:121:1: rule__Lista__Group__1 : rule__Lista__Group__1__Impl ;
    public final void rule__Lista__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:125:1: ( rule__Lista__Group__1__Impl )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:126:2: rule__Lista__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Lista__Group__1__Impl_in_rule__Lista__Group__1190);
            rule__Lista__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lista__Group__1"


    // $ANTLR start "rule__Lista__Group__1__Impl"
    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:132:1: rule__Lista__Group__1__Impl : ( ( rule__Lista__NameAssignment_1 ) ) ;
    public final void rule__Lista__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:136:1: ( ( ( rule__Lista__NameAssignment_1 ) ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:137:1: ( ( rule__Lista__NameAssignment_1 ) )
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:137:1: ( ( rule__Lista__NameAssignment_1 ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:138:1: ( rule__Lista__NameAssignment_1 )
            {
             before(grammarAccess.getListaAccess().getNameAssignment_1()); 
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:139:1: ( rule__Lista__NameAssignment_1 )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:139:2: rule__Lista__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Lista__NameAssignment_1_in_rule__Lista__Group__1__Impl217);
            rule__Lista__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getListaAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lista__Group__1__Impl"


    // $ANTLR start "rule__Lista__NameAssignment_1"
    // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:154:1: rule__Lista__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Lista__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:158:1: ( ( RULE_STRING ) )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:159:1: ( RULE_STRING )
            {
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:159:1: ( RULE_STRING )
            // ../listaCompiler.ui/src-gen/edu/upb/compilacion/ui/contentassist/antlr/internal/InternalListaCompiler.g:160:1: RULE_STRING
            {
             before(grammarAccess.getListaAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Lista__NameAssignment_1256); 
             after(grammarAccess.getListaAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lista__NameAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleLista_in_entryRuleLista61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLista68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lista__Group__0_in_ruleLista94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lista__Group__0__Impl_in_rule__Lista__Group__0128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Lista__Group__1_in_rule__Lista__Group__0131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Lista__Group__0__Impl159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lista__Group__1__Impl_in_rule__Lista__Group__1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lista__NameAssignment_1_in_rule__Lista__Group__1__Impl217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Lista__NameAssignment_1256 = new BitSet(new long[]{0x0000000000000002L});

}