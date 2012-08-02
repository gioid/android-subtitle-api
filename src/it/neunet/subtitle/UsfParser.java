package it.neunet.subtitle;

import it.neunet.subtitle.usf.Author;
import it.neunet.subtitle.usf.Metadata;
import it.neunet.subtitle.usf.Subtitle;
import it.neunet.subtitle.usf.Subtitles;
import it.neunet.subtitle.usf.Usf;
import it.neunet.subtitle.usf.styleable.FontStyle;
import it.neunet.subtitle.usf.styleable.ImageElement;
import it.neunet.subtitle.usf.styleable.KaraokeElement;
import it.neunet.subtitle.usf.styleable.Position;
import it.neunet.subtitle.usf.styleable.ShapeElement;
import it.neunet.subtitle.usf.styleable.Style;
import it.neunet.subtitle.usf.styleable.TextElement;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;

public class UsfParser {
	private Element root;
	private Usf usf;

	public UsfParser(Document doc) {
		this.root = doc.getDocumentElement();
		if(this.root == null)
			Log.w("GIO", doc.getLocalName());
	}

	public Usf getLastParsedDoc() {
		return usf;
	}

	public Usf parseDoc() {
		usf = new Usf();

		usf.setMetadata(parseMetadata());
		usf.setStyles(parseStyles());
		usf.setSubtitles(parseSubtitles());

		return usf;
	}

	/**
	 * Extract the author's information from the given node.
	 * 
	 * @param authorNode
	 *            The node to explore.
	 * @return The author object, representing the information about the author.
	 */
	public Author parseAuthor(Node authorNode) {
		Author author = new Author();

		NodeList authorChild = authorNode.getChildNodes();

		for (int i = 0; i < authorChild.getLength(); i++) {
			Node child = authorChild.item(i);

			if (child.getNodeType() == Node.ELEMENT_NODE) {
				Element detail = (Element) child;
				String nodeName = detail.getNodeName();
				String nodeValue = detail.getFirstChild().getNodeValue();

				if (nodeName.equals("name")) {
					author.setName(nodeValue);
				} else if (nodeName.equals("email")) {
					author.setEmail(nodeValue);
				} else if (nodeName.equals("url")) {
					author.setUrl(nodeValue);
				} else if (nodeName.equals("task")) {
					author.setTask(nodeValue);
				}
			}
		}

		return author;
	}

	/**
	 * Extract the metadata's information from the document.
	 * 
	 * @return The metadata object, representing the information about the
	 *         metadata
	 */
	public Metadata parseMetadata() {
		Metadata metadata = new Metadata();
		// get all the "metadata" nodes (it should be only one)
		NodeList nodes = this.root.getElementsByTagName("metadata");
		// fetch all the "metadata" node
		for (int i = 0; i < nodes.getLength(); i++) {
			Node metadataNode = nodes.item(i);
			// get all the child of the metadata
			NodeList metadataChild = metadataNode.getChildNodes();

			for (int j = 0; j < metadataChild.getLength(); j++) {
				Node child = metadataChild.item(j);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					Element detail = (Element) child;
					// read the tag name
					String nodeName = detail.getNodeName();
					// read the tag value
					String nodeValue = detail.getFirstChild().getNodeValue();

					if (nodeName.equals("title")) {
						metadata.setTitle(nodeValue);
					} else if (nodeName.equals("language")) {
						metadata.setLanguage(nodeValue);
						metadata.setLanguageCode(detail.getAttribute("code"));
					} else if (nodeName.equals("date")) {
						metadata.setDate(nodeValue);
					} else if (nodeName.equals("comment")) {
						metadata.setComment(nodeValue);
					} else if (nodeName.equals("author")) {
						metadata.setAuthor(parseAuthor(child));
					}
				}
			}
		}

		return metadata;
	}

	/**
	 * Extract the font style information, from the given node.
	 * 
	 * @param node
	 *            The node to explore.
	 * @return The FontStyle object representing the information about this Font
	 *         Style
	 */
	public FontStyle parseFontStyle(Node node) {
		FontStyle fontStyle = new FontStyle();
		Element detail = (Element) node;

		fontStyle.setAlpha(detail.getAttribute("alpha"));
		fontStyle.setBackColor(detail.getAttribute("back-color"));
		fontStyle.setColor(detail.getAttribute("color"));
		fontStyle.setFace(detail.getAttribute("face"));
		fontStyle.setFamily(detail.getAttribute("family"));
		fontStyle.setItalic(detail.getAttribute("italic"));
		fontStyle.setOutlineColor(detail.getAttribute("outline-color"));
		fontStyle.setOutlineLevel(detail.getAttribute("outline-level"));
		fontStyle.setShadowColor(detail.getAttribute("shadow-color"));
		fontStyle.setShadowLevel(detail.getAttribute("shadow-level"));
		fontStyle.setSize(detail.getAttribute("size"));
		fontStyle.setUnderline(detail.getAttribute("underline"));
		fontStyle.setWeight(detail.getAttribute("weight"));
		fontStyle.setWrap(detail.getAttribute("wrap"));

		return fontStyle;
	}

	/**
	 * Extract the position information, from the given node.
	 * 
	 * @param node
	 *            The node to explore.
	 * @return The Position object representing the information about this
	 *         position.
	 */
	public Position parsePosition(Node node) {
		Position position = new Position();
		Element detail = (Element) node;

		position.setAlignment(detail.getAttribute("alignment"));
		position.setHorizontalMargin(detail.getAttribute("horizontal-margin"));
		position.setVerticalMargin(detail.getAttribute("vertical-margin"));
		position.setRelativeTo(detail.getAttribute("relative-to"));
		position.setRotateX(detail.getAttribute("rotate-x"));
		position.setRotateY(detail.getAttribute("rotate-y"));
		position.setRotateZ(detail.getAttribute("rotate-z"));

		return position;
	}

	/**
	 * Extract the style information, from the given node.
	 * 
	 * @param node
	 *            The node to explore.
	 * @return The Style object representing the information about this style.
	 */
	public Style parseElementStyle(Node node) {
		Style style = new Style();

		style.setFontStyle(parseFontStyle(node));
		style.setPosition(parsePosition(node));

		return style;
	}

	public HashMap<String, Style> parseStyles() {
		HashMap<String, Style> styles = new HashMap<String, Style>();
		// get all the "style" nodes
		NodeList nodes = this.root.getElementsByTagName("style");
		// fetch all the "style" node
		for (int i = 0; i < nodes.getLength(); i++) {
			Node styleNode = nodes.item(i);
			String styleName = ((Element) styleNode).getAttribute("name");
			Style style = new Style();
			style.setName(styleName);

			// get all the child of the style
			NodeList styleChild = styleNode.getChildNodes();

			for (int j = 0; j < styleChild.getLength(); j++) {
				Node child = styleChild.item(j);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					Element detail = (Element) child;
					// read the tag name
					String nodeName = detail.getNodeName();

					if (nodeName.equals("fontstyle")) {
						style.setFontStyle(parseFontStyle(child));
					} else if (nodeName.equals("position")) {
						style.setPosition(parsePosition(child));
					}
				}
			}
			
			if("Default".equals(styleName))
				Style.setDefault(style);
			else
				styles.put(style.getName(), style);
		}

		return styles;
	}

	private String getRawValue(Element node){
		String rawValue = "";
		
		if(((Node) node).getNodeType() == Node.TEXT_NODE){
			rawValue = node.getNodeValue();
		} else {
			NodeList nodeList = node.getChildNodes();
			for(int i = 0; i < nodeList.getLength(); i++)
			{
				Node child = nodeList.item(i);
				
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					Element childDetail = (Element) child;
					rawValue += "<" + childDetail.getNodeName();
					// add each attribute
					NamedNodeMap nnm = childDetail.getAttributes();
					for(int j = 0; j < nnm.getLength(); j++)
					{
						Node attr = nnm.item(j);
						rawValue += " " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"";
					}
					
					if(childDetail.getChildNodes().getLength() != 0)
						rawValue += ">" + getRawValue(childDetail) +
							"</" + childDetail.getNodeName() + ">";
					else
						rawValue += " />";
					
				} else if(child.getNodeType() == Node.TEXT_NODE){
					rawValue += child.getNodeValue();
				}
				
			}
		}
		
		Log.e("GIO", "rawValue" + rawValue);
		return rawValue;
	}
	
	public TextElement parseText(Node node) {
		TextElement text = new TextElement();
		Element detail = (Element) node;

		// first apply the text attribute
		text.setSpeaker(detail.getAttribute("speaker"));
		text.setXhtmlText(getRawValue(detail));

		Style style = new Style();
		// check if is specified a style
		if (!detail.getAttribute("style").equals("")) {
			// if so, first apply hierarchy this style
			style.applyStyle(usf.getStyleByName(detail.getAttribute("style")));
		}
		// then overwrite the specified value
		style.applyStyle(parseElementStyle(node));

		// finally apply the style to the element
		text.applyStyle(style);

		return text;
	}

	public KaraokeElement parseKaraoke(Node node) {
		KaraokeElement karaoke = new KaraokeElement();
		Element detail = (Element) node;

		// first apply the karaoke attribute
		// TODO: which attribute?

		Style style = new Style();
		// check if is specified a style
		if (!detail.getAttribute("style").equals("")) {
			// if so, first apply hierarchy this style
			style.applyStyle(usf.getStyleByName(detail.getAttribute("style")));
		}
		// then overwrite the specified value
		style.applyStyle(parseElementStyle(node));

		// finally apply the style to the element
		karaoke.applyStyle(style);

		return karaoke;
	}

	public ImageElement parseImage(Node node) {
		ImageElement image = new ImageElement();
		Element detail = (Element) node;

		// first apply the image attribute
		// TODO: which attribute?
		image.setPath(detail.getFirstChild().getNodeValue());

		Style style = new Style();
		// check if is specified a style
		if (!detail.getAttribute("style").equals("")) {
			// if so, first apply hierarchy this style
			style.applyStyle(usf.getStyleByName(detail.getAttribute("style")));
		}
		// then overwrite the specified value
		style.applyStyle(parseElementStyle(node));

		// finally apply the style to the element
		image.applyStyle(style);

		return image;
	}


	
	
	
	
	

	public ShapeElement parseShape(Node node) {
		ShapeElement shape = new ShapeElement();
		Element detail = (Element) node;

		// first apply the image attribute
		// TODO: which attribute?
		shape.setType(detail.getAttribute("type"));
		shape.setHeight(detail.getAttribute("height"));
		shape.setWidth(detail.getAttribute("width"));

		Style style = new Style();
		// check if is specified a style
		if (!detail.getAttribute("style").equals("")) {
			// if so, first apply hierarchy this style
			style.applyStyle(usf.getStyleByName(detail.getAttribute("style")));
		}
		// then overwrite the specified value
		style.applyStyle(parseElementStyle(node));

		// finally apply the style to the element
		shape.applyStyle(style);

		return shape;
	}

	public Subtitle parseSubtitle(Node node) {
		Subtitle subtitle = new Subtitle();
		Element e = (Element) node;

		// set the subtitle's attribute
		subtitle.setDuration(e.getAttribute("duration"));
		subtitle.setStartMillisecond(e.getAttribute("start"));
		subtitle.setEndMillisecond(e.getAttribute("stop"));
		subtitle.setType(e.getAttribute("type"));

		// then find all the element of this subtitle
		NodeList nodes = node.getChildNodes();
		// fetch each element
		for (int i = 0; i < nodes.getLength(); i++) {
			Node child = nodes.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				Element childDetail = (Element) child;

				if (childDetail.getNodeName().equals("text")) {
					subtitle.addText(parseText(child));
				} else if (childDetail.getNodeName().equals("image")) {
					subtitle.addImage(parseImage(child));
				} else if (childDetail.getNodeName().equals("karaoke")) {
					subtitle.addKaraoke(parseKaraoke(child));
				} else if (childDetail.getNodeName().equals("shape")) {
					subtitle.addShape(parseShape(child));
				}
			}
		}

		return subtitle;
	}

	public ArrayList<Subtitles> parseSubtitles() {
		ArrayList<Subtitles> allSubtitles = new ArrayList<Subtitles>();
		// get all the "subtitles" nodes
		NodeList nodes = this.root.getElementsByTagName("subtitles");
		// fetch all the "subtitles" node
		for (int i = 0; i < nodes.getLength(); i++) {
			Subtitles subtitles = new Subtitles();
			Node styleNode = nodes.item(i);

			// get all the child of the style
			NodeList styleChild = styleNode.getChildNodes();

			for (int j = 0; j < styleChild.getLength(); j++) {
				Node child = styleChild.item(j);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					Element detail = (Element) child;
					// read the tag name
					String nodeName = detail.getNodeName();
					// read the node value
					String nodeValue = (detail.getFirstChild() != null)? detail.getFirstChild().getNodeValue(): "";

					if (nodeName.equals("language")) {
						subtitles.setLanguage(nodeValue);
						subtitles.setLanguageCode(detail.getAttribute("code"));
					} else if (nodeName.equals("languageext")) {
						subtitles.setLanguageext(nodeValue);
						subtitles.setLanguageextCode(detail
								.getAttribute("code"));
					} else if (nodeName.equals("subtitle")) {
						subtitles.addSubtitle(parseSubtitle(child));
					}
				}
			}

			allSubtitles.add(subtitles);
		}

		return allSubtitles;
	}
}
