# DNA / RNA complement computation App with FASTA input

### App principle
This App takes a FASTA file as its input and will generate the complement or 
reverse-complement based on the users request.

The App is Ordered in three Layers:

### 1) import of a FASTA file
this is done inside the `importFrame`.
The user will be asked to provide a FASTA file.
Two RadioButtons allow the user to switch between DNA and RNA Sequence. A press 
on the import-Button opens the File Chooser. Has the user found its file and clicked
on OK. The Method [`ImportFrame.Handlers.ImportHandler.handleImport`](https://github.com/AbUndMax/DNA-Complementary-App/blob/a44164e1782119c641f518ea78161300baf105e3/Main/DNAComplementApp/ImportFrame/Handlers/ImportHandler.java#L14) 
gets called. which loads the File into the System.

The Loading is achieved via two while Loops. The first outer Loop will check for three conditions:
- 1) Header marker '>'. If he find a header. a new DNASequence Object is initialized and the header is set as its name.
    a new line of the file is then called and the outer Loop is traversing a step forward.
- 2) comments ';' or empty lines. These are simply skipped and the next line is called. The outer Loops traverses once
    more.
- 3) A line of valid Sequence letters ```"^[ATCGURYKMSWBDHVN-]*$"```