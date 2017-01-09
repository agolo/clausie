package de.mpii.clausie;

import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * An {@code XcompConstituent} of a clause formed out of an xcomp.
 * <p>
 * Note that the xcomp relation refers to a clause with an external subject.
 * The constituent stores the set of clauses that can be derived from the xcomp
 * clause.
 * <p>
 * Date: $LastChangedDate: 2013-04-23 00:04:28 +0200 (Tue, 23 Apr 2013) $
 *
 * @version $LastChangedRevision: 734 $
 */
public class XcompConstituent extends IndexedConstituent {

    /**
     * Clauses derived from this constituent.
     */
    private List<Clause> clauses;

    private XcompConstituent() {
    }

    /**
     * Constructs a new constituent for the xcomp relation.
     *
     * @param semanticGraph Semantic graph for this constituent ({@see {@link #semanticGraph}})
     * @param root          The root vertex of this constituent ({@see {@link #root}})
     * @param type          type of this constituent
     * @param clauses       derived from this constituent
     */
    public XcompConstituent(SemanticGraph semanticGraph,
                            IndexedWord root,
                            Type type,
                            List<Clause> clauses) {
        super(semanticGraph, root, type);
        setClauses(clauses);
    }

    /**
     * Constructs a new indexed constituent for the xcomp relation.
     *
     * @param semanticGraph      Semantic graph for this constituent ({@see {@link #semanticGraph}})
     * @param root               The root vertex of this constituent ({@see {@link #root}})
     * @param additionalVertexes Additional root vertexes that form this constituent ({@see
     *                           {@link #additionalVertexes}})
     * @param excludedVertexes   Vertexes that are excluded from this constituent ({@see
     *                           {@link #excludedVertexes}})
     * @param type               type of this constituent
     * @param clauses            derived from this constituent
     */
    public XcompConstituent(SemanticGraph semanticGraph,
                            IndexedWord root,
                            Set<IndexedWord> additionalVertexes,
                            Set<IndexedWord> excludedVertexes,
                            Type type,
                            List<Clause> clauses) {
        super(semanticGraph, root, additionalVertexes, excludedVertexes, type);
        setClauses(clauses);
    }

    /**
     * Returns the clauses derived from the constituent.
     */
    public List<Clause> getClauses() {
        return clauses;
    }

    /**
     * Sets the clauses derived from the constituent.
     */
    public void setClauses(List<Clause> clauses) {
        this.clauses = clauses;
    }

    @Override
    public XcompConstituent clone() {
        XcompConstituent clone = new XcompConstituent();
        clone.type = type;
        clone.semanticGraph = new SemanticGraph(getSemanticGraph());
        clone.root = getRoot();
        clone.additionalVertexes = new TreeSet<>(additionalVertexes);
        clone.excludedVertexes = new TreeSet<>(excludedVertexes);
        clone.clauses = new ArrayList<>(clauses);
        return clone;
    }
}